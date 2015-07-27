package co.edu.sena.jonathan.events2015;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import co.edu.sena.jonathan.events2015.adapters.AdaptadorGrid;
import co.edu.sena.jonathan.events2015.basedatos.DatosLocales;


public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {

    GridView gridDias;
    AdaptadorGrid adaptadorGrid;
    DatosLocales bdLocal;
    EventsApplication application;

    Spinner spiFiltro;
    EditText edDatosFiltro;
    Button btVerTodo;
    ImageView btBuscar;
    String criterioBusqueda ="";


    int positionSpinner = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            application = (EventsApplication) getApplicationContext();
            bdLocal = new DatosLocales(getApplicationContext());
            cargarDatos();
            adaptadorGrid = new AdaptadorGrid(getApplicationContext());
            init();
        }catch(Exception e){
            Log.e("Error:::_ ", e.toString());
        }
    }

    private void cargarDatos() {

        bdLocal.openBd();
        bdLocal.cargarDias();
        bdLocal.closeBd();
    }

    private void init() {

        spiFiltro = (Spinner) findViewById(R.id.main_spin);
        edDatosFiltro = (EditText) findViewById(R.id.main_ed_filtro);
        btBuscar = (ImageView) findViewById(R.id.main_btn_buscar);
        btVerTodo = (Button) findViewById(R.id.main_btn_verTodos);

        gridDias = (GridView) findViewById(R.id.main_grid);

        gridDias.setAdapter(adaptadorGrid);
        spiFiltro.setOnItemSelectedListener(this);
        gridDias.setOnItemClickListener(this);

    }

    public void filtrarDatos(View view) {


        try {
            if (!(edDatosFiltro.getText().toString().equals(""))) {
                bdLocal.openBd();
                bdLocal.cargarListaEventos(1, criterioBusqueda, edDatosFiltro.getText().toString());
                bdLocal.closeBd();

                Intent ac = new Intent(this, ListaEventosDia.class);
                startActivity(ac);
            } else {
                Toast.makeText(this, "Primero escriba lo que desea buscar", Toast.LENGTH_LONG).show();
            }
        }catch (Exception e){
            Log.e("Error::::_ ", e.toString());
        }
    }

    public void verTodo(View view) {

        bdLocal.openBd();
        bdLocal.cargarListaEventos(0, "", "");
        bdLocal.closeBd();

        Intent ac = new Intent(this, ListaEventosDia.class);
        startActivity(ac);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        positionSpinner = position;
        switch (position){
            case 0: criterioBusqueda = bdLocal.KEY_NAME; break;
            case 1: criterioBusqueda = bdLocal.KEY_PARTICIPANTS; break;
            case 2: criterioBusqueda = bdLocal.KEY_LOCATION; break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        try {
            bdLocal.openBd();
            bdLocal.cargarListaEventos(2, bdLocal.KEY_DAY, application.getListaDias().get(position));
            bdLocal.closeBd();

            Intent ac = new Intent(this, ListaEventosDia.class);
            startActivity(ac);
        }catch (Exception e){
            Log.e("Error::::_ ", e.toString());
        }
    }
}