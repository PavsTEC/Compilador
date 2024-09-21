package com.group2;

public class Main {
    public static void main(String[] args) {
        String codigo = "a = 42;\nb = a - 7;\nc = (a + b) * 2;";

        Lexer lexer = new Lexer();
        lexer.tokenizar(codigo);
    }
}
