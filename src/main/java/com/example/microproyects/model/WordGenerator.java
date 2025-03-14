package com.example.microproyects.model;

import java.util.Random;

/**
 * Esta clase contiene la lista de palabras usadas en el juego,
 * además de la función "generateWords" que retorna una de las palabras.
 *
 * @author Erick Obando
 * @version 1.0
 */
public class WordGenerator {

    /**
     * Arreglo de cadenas que contiene las palabras disponibles para el juego.
     */
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

    /**
     * Genera una palabra aleatoria del arreglo de palabras disponibles.
     *
     * @return Una cadena que representa una palabra aleatoria.
     */
    public static String generateWords() {
        Random random = new Random();
        return WORDS[random.nextInt(WORDS.length)];
    }
}