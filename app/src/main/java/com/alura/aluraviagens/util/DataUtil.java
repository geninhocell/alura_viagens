package com.alura.aluraviagens.util;

import androidx.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataUtil {

    public static final String DIA_E_MES = "dd/MM";

    @NonNull
    public static String periodoEmTexto(int dias) {
        Calendar dataIda = Calendar.getInstance();
        Calendar dataVolta = Calendar.getInstance();
        dataVolta.add(Calendar.DATE, dias);
        SimpleDateFormat formatoBrasil = new SimpleDateFormat(DIA_E_MES);
        String dataIdaFormatada = formatoBrasil.format(dataIda.getTime());
        String dataVoltaFormatada = formatoBrasil.format(dataVolta.getTime());
        String dataFormatadaDaViagem = dataIdaFormatada + " - " + dataVoltaFormatada + " de " + dataVolta.get(Calendar.YEAR);
        return dataFormatadaDaViagem;
    }
}
