package com.alura.aluraviagens.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class MoedaUtil {

    public static final String PORTUGUES = "pt";
    public static final String BRASIL = "br";

    public static String formataParaMoedaBrasileira(BigDecimal valor) {
        NumberFormat formatoBrasil = DecimalFormat.getCurrencyInstance(new Locale(PORTUGUES, BRASIL));
        String moedaBrasileira = formatoBrasil.format(valor);
        return moedaBrasileira;
    }
}
