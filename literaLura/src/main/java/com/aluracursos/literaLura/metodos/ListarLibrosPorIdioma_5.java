package com.aluracursos.literaLura.metodos;

import com.aluracursos.literaLura.menuDeOpciones.MenuIdioma;
import com.aluracursos.literaLura.model.Libro;
import com.aluracursos.literaLura.repository.LibroRepository;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListarLibrosPorIdioma_5 {
    private LibroRepository repositorio;
    private Scanner teclado;

    public ListarLibrosPorIdioma_5(LibroRepository repositorio, Scanner teclado) {
        this.repositorio = repositorio;
        this.teclado = teclado;
    }

    public void listarPorIdioma() {
        // Mostrar el menú de idiomas
        System.out.println(MenuIdioma.getMenuIdioma());

        // Leer la opción seleccionada por el usuario
        int opcion = teclado.nextInt();
        teclado.nextLine(); // Para limpiar el buffer de entrada

        // Declarar la variable de idioma seleccionada como final
        final String idiomaSeleccionado;

        // Definir el idioma basado en la opción seleccionada
        switch (opcion) {
            case 1:
                idiomaSeleccionado = "es"; // Español
                break;
            case 2:
                idiomaSeleccionado = "en"; // Inglés
                break;
            case 3:
                idiomaSeleccionado = "fr"; // Francés
                break;
            case 4:
                idiomaSeleccionado = "pt"; // Portugués
                break;
            case 5:
                idiomaSeleccionado = "de"; // Alemán
                break;
            default:
                System.out.println("Opción inválida.");
                return;
        }

        // Obtener todos los libros desde la base de datos
        List<Libro> libros = repositorio.findAll();

        // Filtrar libros que contengan el idioma seleccionado
        List<Libro> librosFiltrados = libros.stream()
                .filter(libro -> libro.getIdiomas().contains(idiomaSeleccionado)) // Uso de la variable final
                .collect(Collectors.toList());

        // Mostrar los libros filtrados
        if (librosFiltrados.isEmpty()) {
            System.out.println("No hay libros registrados en el idioma seleccionado.");
        } else {
            System.out.println("********************************************************************");
            System.out.println("Libros registrados en el idioma " + idiomaSeleccionado + ":");

            for (Libro libro : librosFiltrados) {
                System.out.println("Título: " + libro.getTitulo());
                System.out.println("Número de descargas: " + libro.getNumeroDeDescargas());

                // Mostrar el autor asociado al libro
                if (libro.getAutor() != null) {
                    System.out.println("Autor:");
                    System.out.println(" - Nombre: " + libro.getAutor().getName());
                    System.out.println("   Año de nacimiento: " + libro.getAutor().getBirthYear());
                    System.out.println("   Año de fallecimiento: " + libro.getAutor().getDeathYear());
                } else {
                    System.out.println("No hay autor registrado para este libro.");
                }

                // Mostrar idiomas
                System.out.println("Idiomas: " + String.join(", ", libro.getIdiomas()));

                // Mostrar formatos disponibles
                System.out.println("Formatos de descarga disponibles:");
                if (libro.getImageJpeg() != null) System.out.println(" - Imagen cubierta del libro: " + libro.getImageJpeg());
                if (libro.getTextPlain() != null) System.out.println(" - Texto plano: " + libro.getTextPlain());
                if (libro.getApplicationOctetStream() != null) System.out.println(" - Descarga: " + libro.getApplicationOctetStream());

                System.out.println("-------------------------------------------------------------");
            }
        }
    }
}
