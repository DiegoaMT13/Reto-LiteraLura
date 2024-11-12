package com.aluracursos.literaLura.principal;

import com.aluracursos.literaLura.menuDeOpciones.MenuDeOpciones;
import com.aluracursos.literaLura.menuDeOpciones.MenuIdioma;
import com.aluracursos.literaLura.metodos.*;
import com.aluracursos.literaLura.model.Datos;
import com.aluracursos.literaLura.model.DatosLibros;

import com.aluracursos.literaLura.repository.LibroRepository;
import com.aluracursos.literaLura.service.ConsumoApi;
import com.aluracursos.literaLura.service.ConvierteDatos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

@Component
public class Principal {

    private static final String URL_BASE = "https://gutendex.com/books/";
    private final ConsumoApi consumoApi = new ConsumoApi();
    private final ConvierteDatos conversor = new ConvierteDatos();
    private final Scanner teclado = new Scanner(System.in);
    private final MenuDeOpciones menuDeOpciones = new MenuDeOpciones();
    private final LibroRepository repositorio;
    private final List<DatosLibros> datosLibros = new ArrayList<>();
    private final MenuIdioma menuIdioma = new MenuIdioma();

    // Inyección de dependencias para clases de funcionalidad específica
    private final ListarLibrosPorIdioma_5 listarLibrosPorIdioma5;
    private final ListarAutoresPorFecha_4 listarAutoresPorFecha4;
    private final ListarAutoresRegistrados_3 listarAutoresRegistrados3;
    private final ListarLibrosRegistrados_2 listarLibrosRegistrados2;
    private final BuscarYGuardarLibroService buscarYGuardarLibroService;

    private final ListarLibrosMasDescargados_6 listarLibrosMasDescargados6;

    // Constructor con inyección
    @Autowired
    public Principal(LibroRepository repositorio) {
        this.repositorio = repositorio;
        this.listarLibrosPorIdioma5 = new ListarLibrosPorIdioma_5(repositorio, teclado);
        this.listarAutoresPorFecha4 = new ListarAutoresPorFecha_4(repositorio, teclado);
        this.listarAutoresRegistrados3 = new ListarAutoresRegistrados_3(repositorio);
        this.listarLibrosRegistrados2 = new ListarLibrosRegistrados_2(repositorio);
        this.buscarYGuardarLibroService = new BuscarYGuardarLibroService(repositorio);
        this.listarLibrosMasDescargados6 = new ListarLibrosMasDescargados_6(repositorio);
    }

    // Acciona y entrelasa la información
    public void muestraMenu() throws UnsupportedEncodingException {
        int opcion = -1;
        while (opcion != 0) {
            System.out.println(menuDeOpciones.getMenu());
            opcion = teclado.nextInt();
            teclado.nextLine();
            switch (opcion) {
                case 1:
                    buscarLibroWeb();
                    break;
                case 2:
                    listarLibrosRegistrados2.listar();
                    break;
                case 3:
                    listarAutoresRegistrados3.listar();
                    break;
                case 4:
                    listarAutoresPorFecha4.listarPorFecha();
                    break;
                case 5:
                    listarLibrosPorIdioma5.listarPorIdioma();
                    break;
                case 6:
                    listarLibrosMasDescargados6.listarTop5LibrosMasDescargados();
                    break;
                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
        teclado.close();
    }

    // Método para buscar un libro y mostrar sus detalles
    private DatosLibros getdatosLibros() throws UnsupportedEncodingException {
        var json = consumoApi.obtenerDatos(URL_BASE);
        var datos = conversor.obtenerDatos(json, Datos.class);

        System.out.println("***********************************************************************");
        System.out.println("Ingresa el nombre del libro:");
        var tituloLibro = teclado.nextLine();

        String encodedTitulo = URLEncoder.encode(tituloLibro, "UTF-8");
        json = consumoApi.obtenerDatos(URL_BASE + "?search=" + encodedTitulo);

        var datosBusqueda = conversor.obtenerDatos(json, Datos.class);
        Optional<DatosLibros> libroBuscado = datosBusqueda.libros().stream()
                .filter(l -> l.titulo().toUpperCase().contains(tituloLibro.toUpperCase()))
                .findFirst();

        if (libroBuscado.isPresent()) {
            DatosLibros libro = libroBuscado.get();
            System.out.println("***********************************************************************");
            System.out.println("Libro encontrado:");
            System.out.println("Título: " + libro.titulo());
            libro.autor().forEach(autor -> {
                System.out.println(" (Autor: " + autor.nombre() +
                        " (Nacimiento: " + autor.fechaDeNacimiento() +
                        ", Fallecimiento: " + autor.fechaDefallecimiento() + ")");
            });
            System.out.println("Idiomas: " + String.join(", ", libro.idiomas()));
            System.out.println("Número de descargas: " + libro.numeroDeDescargas());
            System.out.println("Temas: " + String.join(", ", libro.temas()));
            System.out.println("Estanterías: " + String.join(", ", libro.estanterias()));
            System.out.println("Formatos de descarga:");
            libro.formatos().forEach((tipo, url) -> {
                System.out.println(tipo + " -> " + url);
            });
            System.out.println("***********************************************************************");
            return libro;
        } else {
            System.out.println("***********************************************************************");
            System.out.println("Libro no encontrado");
            return null;
        }
    }

    // Método para buscar y guardar un libro en la base de datos
    private void buscarLibroWeb() throws UnsupportedEncodingException {
        DatosLibros datos = getdatosLibros();
        if (datos != null) {
            buscarYGuardarLibroService.buscarYGuardarLibro(datos);
        } else {
            System.out.println("No se añadió ningún libro a la base de datos, ya que no se encontró.");
        }
    }


}

