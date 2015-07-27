package co.edu.sena.jonathan.events2015;

import android.app.Application;

import java.util.ArrayList;

import co.edu.sena.jonathan.events2015.data.ItemColor;

/**
 * Created by Carmanu on 27/07/2015.
 */
public class EventsApplication extends Application {

    private ArrayList<ItemColor> listaColores;

    public ArrayList<ItemColor> getListaColores() {
        return listaColores;
    }

    public void setListaColores(ArrayList<ItemColor> listaColores) {
        this.listaColores = listaColores;
    }
}
