package com.aluracursos.literaLura.menuDeOpciones;

public class MenuIdioma {
    private static String menuIdioma = """
            =====================================================================
                            Biblioteca de Libros por lenguaje
            =====================================================================
            Primero: escribe solo el numero,
            =====================================================================
            1 - es - español
            2 - en - inglés
            3 - fr - Frances
            4 - pt - portugués
            5 - de - Aleman
        
            Elije una opción válida:
            =====================================================================
            """;

    public static String getMenuIdioma() {
        return menuIdioma;
    }

    public MenuIdioma() {
    }
}
