package co.edu.sena.jonathan.events2015;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;

import co.edu.sena.jonathan.events2015.adapters.AdaptadorGrid;
import co.edu.sena.jonathan.events2015.basedatos.DatosLocales;


public class MainActivity extends Activity {

    GridView gridDias;
    AdaptadorGrid adaptadorGrid;
    DatosLocales bdLocal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            bdLocal = new DatosLocales(getApplicationContext());
            cargarDatos();
            adaptadorGrid = new AdaptadorGrid(getApplicationContext());
            init();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void cargarDatos() {

        bdLocal.openBd();
        bdLocal.cargarDias();
        bdLocal.closeBd();
    }

    private void init() {

        gridDias = (GridView) findViewById(R.id.main_grid);

    }
}