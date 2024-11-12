package com.aluracursos.literaLura.metodos;

import com.aluracursos.literaLura.model.Libro;
import com.aluracursos.literaLura.model.autor.Autor;
import com.aluracursos.literaLura.repository.LibroRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ListarLibrosRegistrados_2 {
    private final LibroRepository repositorio;

    public ListarLibrosRegistrados_2(LibroRepository repositorio) {
        this.repositorio = repositorio;
    }

    @Transactional
    public void listar() {
        List<Libro> libros = repositorio.findAll();

        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados en la base de datos.");
        } else {
            System.out.println("********************************************************************");
            System.out.println("Libros registrados en la base de datos:");
            for (Libro libro : libros) {
                System.out.println("Título: " + libro.getTitulo());
                System.out.println("Número de descargas: " + libro.getNumeroDeDescargas());

                // Mostrar el autor asociado al libro
                Autor autor = libro.getAutor();
                if (autor != null) {
                    System.out.println("Autor:");
                    System.out.println(" - Nombre: " + autor.getName());
                    System.out.println("   Año de nacimiento: " + autor.getBirthYear());
                    System.out.println("   Año de fallecimiento: " + autor.getDeathYear());
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

