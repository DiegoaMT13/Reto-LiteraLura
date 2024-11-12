package com.aluracursos.literaLura.service;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvierteDatos implements IConvierteDatos{

    private final ObjectMapper Mapper = new ObjectMapper();

    @Override
    public <T> T obtenerDatos(String json, Class<T> clase) {

        try {
            return Mapper.readValue(json, clase);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
