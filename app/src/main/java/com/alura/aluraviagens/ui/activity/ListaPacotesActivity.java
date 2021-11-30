package com.alura.aluraviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.alura.aluraviagens.R;
import com.alura.aluraviagens.dao.PacoteDAO;
import com.alura.aluraviagens.model.Pacote;
import com.alura.aluraviagens.ui.adapter.ListaPacotesAdapter;

import java.util.List;

public class ListaPacotesActivity extends AppCompatActivity {

    public static final String TITULO_PACOTES = "Pacotes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);
        setTitle(TITULO_PACOTES);

        configuraLista();


    }

    private void configuraLista() {
        ListView listaDePacotes = findViewById(R.id.lista_pacotes_listview);
        final List<Pacote> pacotes = new PacoteDAO().lista();
        listaDePacotes.setAdapter(new ListaPacotesAdapter(pacotes, this));
        listaDePacotes.setOnItemClickListener((parent, view, position, id) -> {
            Pacote pacoteClicado = pacotes.get(position);
            Intent intent = new Intent(ListaPacotesActivity.this, ResumoPacoteActivity.class);
            intent.putExtra("pacote", pacoteClicado);
            startActivity(intent);
        });
    }
}