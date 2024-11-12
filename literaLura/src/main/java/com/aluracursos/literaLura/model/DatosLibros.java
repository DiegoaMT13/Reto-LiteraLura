package com.aluracursos.literaLura.model;

import com.aluracursos.literaLura.model.autor.DatosAutor;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Map;


@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibros(


        @JsonAlias("title") String titulo,
        @JsonAlias("authors") List<DatosAutor> autor,
        @JsonAlias("languages") List<String> idiomas,
        @JsonAlias("subjects") List<String> temas,
        @JsonAlias("bookshelves") List<String> estanterias,
        @JsonAlias("formats") Map<String, String> formatos,
        @JsonAlias("download_count") Double numeroDeDescargas


) {


}
