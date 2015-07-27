package co.edu.sena.jonathan.events2015.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import co.edu.sena.jonathan.events2015.EventsApplication;
import co.edu.sena.jonathan.events2015.R;

/**
 * Created by jeison on 27/07/2015.
 */
public class AdaptadorLista extends BaseAdapter{

    Context context;
    private EventsApplication application;

    public AdaptadorLista(Context context) {
        this.context = context;
        this.application = (EventsApplication) context;
    }

    @Override
    public int getCount() {
        return application.getListaEventos().size();
    }

    @Override
    public Object getItem(int i) {
        return application.getListaEventos().get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public class ViewHolder{
        TextView txtNombre;
        TextView txtDia;
        TextView txtParticipantes;
        ImageView imgIr;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v=view;
        ViewHolder holder = new ViewHolder();
        if (v==null){
            v=View.inflate(context,R.layout.item_lista,null);

            holder.txtNombre= (TextView) v.findViewById(R.id.itemLista_nombre);
            holder.txtDia= (TextView) v.findViewById(R.id.itemLista_dia);
            holder.txtParticipantes= (TextView) v.findViewById(R.id.itemLista_participa);
            holder.imgIr= (ImageView) v.findViewById(R.id.itemLista_img);

            v.setTag(holder);
        }else{
            holder= (ViewHolder) v.getTag();
        }

        holder.txtNombre.setText(application.getListaEventos().get(i).getNombre());
        holder.txtParticipantes.setText(application.getListaEventos().get(i).getParticipantes());
        holder.txtDia.setText(application.getListaEventos().get(i).getDia());

        if (application.getListaEventos().get(i).getEstado()==1){
            holder.imgIr.setImageResource(R.drawable.logo_estd_1);
        }else {
            holder.imgIr.setImageResource(R.drawable.logo_estd_0);
        }

        if (application.getListaEventos().get(i).getEncabesado()==0){
            v.setBackgroundResource(R.color.fondo_lista_azul);
        }else{
            v.setBackgroundResource(R.color.fondo_lista_blanco);
        }

        return v;
    }
}
