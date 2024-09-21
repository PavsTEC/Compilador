package com.group2;

public class Main {
    public static void main(String[] args) {
        String codigo = "a12 = 42;";

        Lexer lexer = new Lexer();
        lexer.tokenizar(codigo);
    }
}
