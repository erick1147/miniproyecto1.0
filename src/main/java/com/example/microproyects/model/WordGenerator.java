package com.example.microproyects.model;

import java.util.Random;

/*
 * Esta clase contiene la lista de palabras usadas en el juego,
 * ademas de la funcion "generateWords" que retorna una de las palabras
 */
public  class WordGenerator {
    private static final String[] WORDS = {"agua", "sol", "luz", "mar", "rio", "cielo", "nube", "luna", "estrella", "fuego",
            "tierra", "viento", "bosque", "arbol", "flor", "hoja", "piedra", "arena", "montana", "cerro",
            "valle", "playa", "isla", "oceano", "laguna", "cascada", "cueva", "roca", "desierto", "jungla",
            "animal", "perro", "gato", "pajaro", "pez", "tigre", "leon", "elefante", "jirafa", "mono",
            "serpiente", "rana", "tortuga", "delfin", "ballena", "caballo", "vaca", "oveja", "cerdo", "gallina",
            "abeja", "mariposa", "araña", "hormiga", "caracol", "camaron", "pulpo", "medusa", "cangrejo", "erizo",
            "fruta", "manzana", "pera", "uva", "banana", "naranja", "limon", "sandia", "melon", "piña",
            "cereza", "fresa", "mango", "kiwi", "papaya", "durazno", "ciruela", "frambuesa", "mora", "coco",
            "verdura", "zanahoria", "tomate", "papa", "cebolla", "ajo", "lechuga", "espinaca", "pepino", "calabaza",
            "maiz", "arroz", "trigo", "avena", "pan", "queso", "leche", "huevo", "miel", "chocolate"
    };

    public static String generateWords() {
        Random random = new Random();
        return WORDS[random.nextInt(WORDS.length)];
    }

}
