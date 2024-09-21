package com.group2;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Token {
    private final String valor;
    private final String atributo;

    @Override
    public String toString() {
        return "valor: " + valor + ", Tipo: " + atributo;
    }
}
