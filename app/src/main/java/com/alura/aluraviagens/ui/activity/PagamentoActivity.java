package com.alura.aluraviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
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

        Intent intentPacote = getIntent();
        if(intentPacote.hasExtra("pacote")){
            final Pacote pacote = (Pacote) intentPacote.getSerializableExtra("pacote");

            mostraPreco(pacote);

            Button botaoFinalizaPagamento = findViewById(R.id.pagamento_botao_finaliza_compra);
            botaoFinalizaPagamento.setOnClickListener(v -> {
                Intent intent = new Intent(PagamentoActivity.this, ResumoCompraActivity.class);
                intent.putExtra("pacote", pacote);
                startActivity(intent);
            });
        }
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.pagamento_preco_pacote);
        String moedaBrasil = MoedaUtil.formataParaMoedaBrasileira(pacote.getPreco());
        preco.setText(moedaBrasil);
    }
}