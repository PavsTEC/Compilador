package com.group2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexer {
    public TablaTokens tokenizar(String input) {
        TablaTokens tabla = new TablaTokens();
        int linea = 1; // Contador de líneas

        // Definición de expresiones regulares para los tokens
        String regexIdentificador = "[a-z]{1,12}";
        String regexNumero = "[0-9]+";
        String regexAsignacion = "=";
        String regexSuma = "\\+";
        String regexResta = "-";
        String regexMultiplicacion = "\\*";
        String regexDivision = "/";
        String regexParentesisIzq = "\\(";
        String regexParentesisDer = "\\)";
        String regexPuntoComa = ";";
        String regexError = "[a-z]+[0-9]+|[0-9]+[a-z]+"; // Errores: letras seguidas de números o viceversa Ej: a12 o
                                                         // 12a

        // Combina todas las expresiones regulares en una sola
        String regex = String.join("|",
                regexIdentificador,
                regexNumero,
                regexAsignacion,
                regexSuma,
                regexResta,
                regexMultiplicacion,
                regexDivision,
                regexParentesisIzq,
                regexParentesisDer,
                regexPuntoComa,
                regexError // Agrega el regex de error al final para detección
        );

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String tokenStr = matcher.group();
            Token token = null;

            if (tokenStr.matches(regexError)) {
                // Si se detecta un error léxico, imprime un mensaje
                System.out.printf("Error [Fase Léxica]: La línea %d contiene un error, lexema no reconocido: %s\n",
                        linea, tokenStr);
            } else {
                // Identificar el tipo de token
                String tipo = identificarTipo(tokenStr);
                token = new Token(tokenStr, tipo); // Crear un nuevo token
                tabla.agregar(token, linea); // Agregar el token a la tabla
            }
        }

        // Imprimir la tabla de tokens
        tabla.imprimirTokens();
        return tabla; // Devuelve la tabla de tokens
    }

    private String identificarTipo(String tokenStr) {
        if (tokenStr.matches("[a-z]{1,12}")) {// identificadores deben ser en minuscula y maximo de 12 letras
            return "IDENTIFICADOR";
        } else if (tokenStr.matches("[0-9]+")) {
            return "NUMERO";
        } else if (tokenStr.equals("=")) {
            return "ASIGNACION";
        } else if (tokenStr.equals("+")) {
            return "SUMA";
        } else if (tokenStr.equals("-")) {
            return "RESTA";
        } else if (tokenStr.equals("*")) {
            return "MULTIPLICACION";
        } else if (tokenStr.equals("/")) {
            return "DIVISION";
        } else if (tokenStr.equals("(")) {
            return "PARENTESIS_IZQ";
        } else if (tokenStr.equals(")")) {
            return "PARENTESIS_DER";
        } else if (tokenStr.equals(";")) {
            return "PUNTO_COMA";
        }
        return "DESCONOCIDO"; // En caso de que no se reconozca el tipo
    }
}
