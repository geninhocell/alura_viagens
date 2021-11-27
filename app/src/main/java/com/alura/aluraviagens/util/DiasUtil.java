package com.alura.aluraviagens.util;

import com.alura.aluraviagens.model.Pacote;

public class DiasUtil {
    public static final String PRURAL = " dias";
    public static final String SINGULAR = " dia";

    public static String formataEmTexto(int quantidadeDeDias) {
        if (quantidadeDeDias > 1) {
            return quantidadeDeDias + PRURAL;
        }
        return quantidadeDeDias + SINGULAR;
    }
}
