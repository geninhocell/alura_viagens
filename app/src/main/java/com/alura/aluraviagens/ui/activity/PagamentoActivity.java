package com.alura.aluraviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.alura.aluraviagens.R;
import com.alura.aluraviagens.model.Pacote;
import com.alura.aluraviagens.util.MoedaUtil;

import java.math.BigDecimal;

public class PagamentoActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Pagamento";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);
        setTitle(TITULO_APPBAR);

        Pacote pacote = new Pacote("São Paulo", "sao_paulo_sp", 2, new BigDecimal("243.45"));

        mostraPreco(pacote);
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.pagamento_preco_pacote);
        String moedaBrasil = MoedaUtil.formataParaMoedaBrasileira(pacote.getPreco());
        preco.setText(moedaBrasil);
    }
}