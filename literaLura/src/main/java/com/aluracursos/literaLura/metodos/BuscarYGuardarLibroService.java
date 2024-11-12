package com.aluracursos.literaLura.metodos;

import com.aluracursos.literaLura.model.DatosLibros;
import com.aluracursos.literaLura.model.Libro;
import com.aluracursos.literaLura.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class BuscarYGuardarLibroService {

    private final LibroRepository repositorio;

    @Autowired
    public BuscarYGuardarLibroService(LibroRepository repositorio) {
        this.repositorio = repositorio;
    }

    public void buscarYGuardarLibro(DatosLibros datos) {
        if (datos != null) {
            // Verificar si el libro ya existe en la base de datos
            Optional<Libro> libroExistente = repositorio.findByTitulo(datos.titulo());
            if (libroExistente.isPresent()) {
                System.out.println("***********************************************************************");
                System.out.println("El libro ya fue guardado previamente en la base de datos: " + datos.titulo());
                System.out.println("***********************************************************************");
            } else {
                // Si el libro no existe, lo guardamos en la base de datos
                Libro libro = new Libro(datos);
                repositorio.save(libro);
                System.out.println("***********************************************************************");
                System.out.println("Libro añadido a la base de datos: " + datos.titulo());
                System.out.println("***********************************************************************");
            }
        } else {
            System.out.println("No se añadió ningún libro a la base de datos, ya que no se encontró.");
        }
    }
}

