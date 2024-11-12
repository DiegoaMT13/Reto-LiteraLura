package com.aluracursos.literaLura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public record Datos(
        @JsonAlias("count") int totalLibros,
        @JsonAlias("next") String siguientePagina,
        @JsonAlias("previous") String paginaAnterior,
        @JsonAlias("results") List<DatosLibros> libros
) {

}
