package com.aluracursos.literaLura.metodos;

import com.aluracursos.literaLura.model.Libro;
import com.aluracursos.literaLura.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarLibrosMasDescargados_6 {

    private final LibroRepository repositorio;

    @Autowired
    public ListarLibrosMasDescargados_6(LibroRepository repositorio) {
        this.repositorio = repositorio;
    }

    public void listarTop5LibrosMasDescargados() {
        List<Libro> libros = repositorio.findAll();
        libros.sort((libro1, libro2) -> Double.compare(libro2.getNumeroDeDescargas(), libro1.getNumeroDeDescargas()));

        System.out.println("********************************************************************");
        System.out.println("Los 5 libros más descargados en la base de datos:");
        System.out.println("********************************************************************");
        int contador = 0;
        for (Libro libro : libros) {
            if (contador >= 5) break;
            System.out.println("Título: " + libro.getTitulo());
            System.out.println("Autor: " + libro.getAutor().getName());
            System.out.println("Número de descargas: " + libro.getNumeroDeDescargas());
            System.out.println("Formatos de descarga disponibles:");
            if (libro.getImageJpeg() != null) System.out.println(" - Imagen cubierta del libro: " + libro.getImageJpeg());
            if (libro.getTextPlain() != null) System.out.println(" - Texto plano: " + libro.getTextPlain());
            if (libro.getApplicationOctetStream() != null) System.out.println(" - Descarga: " + libro.getApplicationOctetStream());


            System.out.println("-------------------------------------------------------------");
            contador++;
        }

        if (contador == 0) {
            System.out.println("No hay libros registrados con información de descargas.");
        }
    }
}
