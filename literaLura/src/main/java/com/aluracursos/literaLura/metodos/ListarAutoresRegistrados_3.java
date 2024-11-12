package com.aluracursos.literaLura.metodos;

import com.aluracursos.literaLura.model.Libro;
import com.aluracursos.literaLura.model.autor.Autor;
import com.aluracursos.literaLura.repository.LibroRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class ListarAutoresRegistrados_3 {

    private final LibroRepository repositorio;

    public ListarAutoresRegistrados_3(LibroRepository repositorio) {
        this.repositorio = repositorio;
    }

    @Transactional
    public void listar() {
        List<Libro> libros = repositorio.findAll();
        Map<Autor, StringBuilder> autoresYLibros = new HashMap<>();

        // Procesamos cada libro y agrupamos por autor
        for (Libro libro : libros) {
            Autor autor = libro.getAutor();
            if (autor != null) {
                // Inicializa el StringBuilder si el autor no existe en el mapa
                autoresYLibros.putIfAbsent(autor, new StringBuilder());
                StringBuilder librosDeAutor = autoresYLibros.get(autor);

                // Agrega el título del libro con un separador si ya existen otros libros
                if (librosDeAutor.length() > 0) {
                    librosDeAutor.append(" ; ");
                }
                librosDeAutor.append(libro.getTitulo());
            }
        }

        // Mostrar autores registrados
        if (autoresYLibros.isEmpty()) {
            System.out.println("No hay autores registrados en la base de datos.");
        } else {
            System.out.println("********************************************************************");
            System.out.println("Autores registrados en la base de datos:");

            for (Map.Entry<Autor, StringBuilder> entry : autoresYLibros.entrySet()) {
                Autor autor = entry.getKey();
                StringBuilder librosDeAutor = entry.getValue();

                System.out.println("Nombre: " + autor.getName());
                System.out.println("Año de nacimiento: " + autor.getBirthYear());
                System.out.println("Año de fallecimiento: " + autor.getDeathYear());
                System.out.println("Libros: " + librosDeAutor.toString());
                System.out.println("-------------------------------------------------------------");
            }
        }
    }
}


