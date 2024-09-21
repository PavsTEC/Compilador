package com.group2;

public class Lexer {
    public TablaTokens tokenizar(String input) {
        TablaTokens tabla = new TablaTokens();

        // De aqui para abajo hay que cambiarlo
        StringBuilder buffer = new StringBuilder();

        int length = input.length();
        for (int i = 0; i < length; i++) {
            char currentChar = input.charAt(i);

            if (Character.isLetter(currentChar)) {
                buffer.append(currentChar);
                while (i + 1 < length
                        && (Character.isLetterOrDigit(input.charAt(i + 1)) || input.charAt(i + 1) == '_')) {
                    i++;
                    buffer.append(input.charAt(i));
                }
                Token token = new Token(buffer.toString(), "IDENTIFICADOR");
                tabla.agregar(token, String.valueOf(1)); // Suponiendo línea 1 para simplicidad
                buffer.setLength(0);
            } else if (Character.isDigit(currentChar)) {
                buffer.append(currentChar);
                while (i + 1 < length && Character.isDigit(input.charAt(i + 1))) {
                    i++;
                    buffer.append(input.charAt(i));
                }
                Token token = new Token(buffer.toString(), "NUMERO");
                tabla.agregar(token, String.valueOf(1)); // Suponiendo línea 1 para simplicidad
                buffer.setLength(0);
            } else if (currentChar == '=') {
                Token token = new Token(String.valueOf(currentChar), "ASIGNACION");
                tabla.agregar(token, String.valueOf(1)); // Suponiendo línea 1 para simplicidad
            } else if (currentChar == '+') {
                Token token = new Token(String.valueOf(currentChar), "SUMA");
                tabla.agregar(token, String.valueOf(1)); // Suponiendo línea 1 para simplicidad
            } else if (currentChar == '-') {
                Token token = new Token(String.valueOf(currentChar), "RESTA");
                tabla.agregar(token, String.valueOf(1)); // Suponiendo línea 1 para simplicidad
            } else if (currentChar == '*') {
                Token token = new Token(String.valueOf(currentChar), "MULTIPLICACION");
                tabla.agregar(token, String.valueOf(1)); // Suponiendo línea 1 para simplicidad
            } else if (currentChar == '(') {
                Token token = new Token(String.valueOf(currentChar), "PARENTESIS_IZQ");
                tabla.agregar(token, String.valueOf(1)); // Suponiendo línea 1 para simplicidad
            } else if (currentChar == ')') {
                Token token = new Token(String.valueOf(currentChar), "PARENTESIS_DER");
                tabla.agregar(token, String.valueOf(1)); // Suponiendo línea 1 para simplicidad
            } else if (currentChar == ';') {
                Token token = new Token(String.valueOf(currentChar), "PUNTO_COMA");
                tabla.agregar(token, String.valueOf(1)); // Suponiendo línea 1 para simplicidad
            } else if (Character.isWhitespace(currentChar)) {
                // Ignorar espacios
            } else {
                throw new IllegalArgumentException("Caracter no reconocido: " + currentChar);
            }
        }
        // De aqui para arriba hay que cambiarlo

        tabla.imprimirTokens(); // Imprime la tabla de tokens
        return tabla; // Devuelve la tabla de tokens
    }
}
