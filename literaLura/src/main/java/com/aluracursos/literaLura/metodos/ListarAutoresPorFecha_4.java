package com.aluracursos.literaLura.metodos;

import com.aluracursos.literaLura.model.Libro;
import com.aluracursos.literaLura.model.autor.Autor;
import com.aluracursos.literaLura.repository.LibroRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ListarAutoresPorFecha_4 {

    private LibroRepository repositorio;
    private Scanner teclado;

    public ListarAutoresPorFecha_4(LibroRepository repositorio, Scanner teclado) {
        this.repositorio = repositorio;
        this.teclado = teclado;
    }

    public void listarPorFecha() {
        System.out.println("Ingresa el año de inicio del rango de fechas (por año):");
        int fechaInicio = teclado.nextInt();
        System.out.println("Ingresa el año final del rango de fechas (por año):");
        int fechaFin = teclado.nextInt();

        List<Libro> libros = repositorio.findAll();
        Map<Autor, StringBuilder> autoresYLibros = new HashMap<>();

        // Filtrar autores cuya fecha de fallecimiento esté dentro del rango especificado
        for (Libro libro : libros) {
            Autor autor = libro.getAutor();
            if (autor != null) {
                Integer birthYear = autor.getBirthYear();
                Integer deathYear = autor.getDeathYear();

                // Filtrar autores cuyo año de nacimiento y fallecimiento estén dentro del rango
                if (birthYear != null && deathYear != null && birthYear <= fechaFin && deathYear >= fechaInicio) {
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
        }

        // Imprimir los autores con el año de fallecimiento dentro del rango especificado
        if (autoresYLibros.isEmpty()) {
            System.out.println("No hay autores registrados con un año de fallecimiento dentro del rango especificado.");
        } else {
            System.out.println("********************************************************************");
            System.out.println("Autores con año de nacimiento y/o fallecimiento entre (" + fechaInicio + ") y (" + fechaFin + "):");

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

