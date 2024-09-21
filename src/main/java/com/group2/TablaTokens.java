package com.group2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class TablaTokens {

    @Getter
    @AllArgsConstructor
    class Informacion {
        private int linea;
    }

    private Map<Token, Informacion> tabla; // Mapa para almacenar tokens y su información

    public TablaTokens() {
        this.tabla = new HashMap<>();
    }

    // Método para agregar un token a la tabla
    public void agregar(Token token, int linea) {
        tabla.put(token, new Informacion(linea));
    }

    // Método para obtener lista de tokens
    public ArrayList<Token> toList() {
        ArrayList<Token> tokens = new ArrayList<>();
        for (Map.Entry<Token, Informacion> entry : tabla.entrySet()) {
            tokens.add(entry.getKey());
        }
        return tokens;
    }

    // Método para imprimir todos los tokens
    public void imprimirTokens() {
        for (Map.Entry<Token, Informacion> entry : tabla.entrySet()) {
            System.out.println(entry.getKey());
        }
    }

    // Método para imprimir todos los tokens y su información
    public void imprimirTabla() {
        for (Map.Entry<Token, Informacion> entry : tabla.entrySet()) {
            System.out.println(entry.getKey() + ", Línea: " + entry.getValue().getLinea());
        }
    }
}
