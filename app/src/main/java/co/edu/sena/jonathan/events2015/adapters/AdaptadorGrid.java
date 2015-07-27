package co.edu.sena.jonathan.events2015.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import co.edu.sena.jonathan.events2015.EventsApplication;
import co.edu.sena.jonathan.events2015.R;
import co.edu.sena.jonathan.events2015.data.EventoColorAma;
import co.edu.sena.jonathan.events2015.data.EventoColorAzul;
import co.edu.sena.jonathan.events2015.data.EventoColorRojo;
import co.edu.sena.jonathan.events2015.data.EventoColorVerde;
import co.edu.sena.jonathan.events2015.data.ItemColor;

/**
 * Created by Carmanu on 27/07/2015.
 */
public class AdaptadorGrid extends BaseAdapter {

    private Context context;
    private EventsApplication application;

    public AdaptadorGrid(Context context) {
        this.context = context;
        application = (EventsApplication) context;
    }

    @Override
    public int getCount() {
        return application.getListaColores().size();
    }

    @Override
    public Object getItem(int position) {
        return application.getListaColores().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v;

        if(convertView == null){
            v = View.inflate(context, R.layout.item_grid, null);
        }else{
            v = convertView;
        }

        TextView txtName = (TextView) v.findViewById(R.id.item_grid_txt_name);

        ItemColor itemColor = (ItemColor) getItem(position);
        switch (itemColor.colorGrid()){

            case 1:
                EventoColorAzul colorAzul = (EventoColorAzul) itemColor;
                txtName.setText(colorAzul.getName());
                txtName.setBackgroundColor(context.getResources().getColor(R.color.color_azul));
                break;
            case 2:
                EventoColorVerde colorVerde = (EventoColorVerde) itemColor;
                txtName.setText(colorVerde.getName());
                txtName.setBackgroundColor(context.getResources().getColor(R.color.color_verde));
                break;
            case 3:
                EventoColorRojo colorRojo = (EventoColorRojo) itemColor;
                txtName.setText(colorRojo.getName());
                txtName.setBackgroundColor(context.getResources().getColor(R.color.color_rojo));
                break;
            case 4:
                EventoColorAma colorAma = (EventoColorAma) itemColor;
                txtName.setText(colorAma.getName());
                txtName.setBackgroundColor(context.getResources().getColor(R.color.color_ama));
                break;
        }

        return v;
    }
}
