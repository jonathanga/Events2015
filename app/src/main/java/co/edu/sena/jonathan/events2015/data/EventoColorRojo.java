package co.edu.sena.jonathan.events2015.data;

/**
 * Created by Carmanu on 27/07/2015.
 */
public class EventoColorRojo implements ItemColor {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int colorGrid() {
        return 3;
    }
}
