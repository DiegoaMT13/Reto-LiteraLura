package com.aluracursos.literaLura.menuDeOpciones;

public class MenuDeOpciones {


    private static String menu = """
            =====================================================================
                                   Biblioteca de Libros
            =====================================================================
            Primero: escribe solo el numero,
            =====================================================================
            1 - Buscar libro por titulo
            2 - Listar libros Registrados
            3 - Listar autores registrados
            4 - Listar autores vivos en un determinado año
            5 - Listar libros por idioma
            6 - Top 5 libros más descargados
            0 - Salir
           
            Elije una opción válida:
            =====================================================================
            """;

    public static String getMenu() {
        return menu;
    }

    public MenuDeOpciones() {
    }
}
