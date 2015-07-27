package co.edu.sena.jonathan.events2015;

import android.app.Application;

import java.lang.reflect.Array;
import java.util.ArrayList;

import co.edu.sena.jonathan.events2015.data.Evento;
import co.edu.sena.jonathan.events2015.data.ItemColor;

/**
 * Created by Carmanu on 27/07/2015.
 */
public class EventsApplication extends Application {

    private ArrayList<ItemColor> listaColores;
    private ArrayList<String> listaDias;
    private ArrayList<Evento> listaEventos;

    public ArrayList<String> getListaDias() {
        return listaDias;
    }

    public void setListaDias(ArrayList<String> listaDias) {
        this.listaDias = listaDias;
    }

    public ArrayList<ItemColor> getListaColores() {
        return listaColores;
    }

    public void setListaColores(ArrayList<ItemColor> listaColores) {
        this.listaColores = listaColores;
    }

    public ArrayList<Evento> getListaEventos(){
        return listaEventos;
    }

    public void setListaEventos(ArrayList<Evento> listaEventos){
        this.listaEventos=listaEventos;
    }
}
