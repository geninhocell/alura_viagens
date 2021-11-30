package com.alura.aluraviagens.ui.activity;

import static com.alura.aluraviagens.ui.activity.PacoteActivityConstantes.CHAVE_PACOTE;

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

        carregaPacoteRecebido();
    }

    private void carregaPacoteRecebido() {
        Intent intentPacote = getIntent();
        if(intentPacote.hasExtra(CHAVE_PACOTE)){
            final Pacote pacote = (Pacote) intentPacote.getSerializableExtra(CHAVE_PACOTE);

            mostraPreco(pacote);

            configuraBotao(pacote);
        }
    }

    private void configuraBotao(Pacote pacote) {
        Button botaoFinalizaPagamento = findViewById(R.id.pagamento_botao_finaliza_compra);
        botaoFinalizaPagamento.setOnClickListener(v -> {
            vaiParaResumoCompra(pacote);
        });
    }

    private void vaiParaResumoCompra(Pacote pacote) {
        Intent intent = new Intent(PagamentoActivity.this, ResumoCompraActivity.class);
        intent.putExtra(CHAVE_PACOTE, pacote);
        startActivity(intent);
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.pagamento_preco_pacote);
        String moedaBrasil = MoedaUtil.formataParaMoedaBrasileira(pacote.getPreco());
        preco.setText(moedaBrasil);
    }
}