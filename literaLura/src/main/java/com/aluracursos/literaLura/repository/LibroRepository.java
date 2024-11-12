package com.aluracursos.literaLura.repository;

import com.aluracursos.literaLura.model.Libro;
import com.aluracursos.literaLura.model.autor.Autor;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {

    Optional<Libro> findByTitulo(String titulo);

    @EntityGraph(attributePaths = "autor")  // Cambiado a "autor" en lugar de "autores"
    List<Libro> findAll();
}