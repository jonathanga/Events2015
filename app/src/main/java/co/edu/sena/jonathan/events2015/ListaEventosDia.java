package co.edu.sena.jonathan.events2015;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import co.edu.sena.jonathan.events2015.adapters.AdaptadorLista;


public class ListaEventosDia extends Activity implements AdapterView.OnItemClickListener {

    ListView lstEventos;
    Button btAgendarTodo;

    AdaptadorLista adapterLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_eventos_dia);

        adapterLista = new AdaptadorLista(getApplicationContext());
        init();
    }

    private void init() {
        lstEventos = (ListView) findViewById(R.id.lista_evento_lista);
        btAgendarTodo = (Button) findViewById(R.id.lista_evento_agregarTodos);

        lstEventos.setAdapter(adapterLista);
        lstEventos.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent ac = new Intent(this, DetalleActivity.class);
        startActivity(ac);
    }
}