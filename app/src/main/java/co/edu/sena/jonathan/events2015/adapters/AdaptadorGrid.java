package co.edu.sena.jonathan.events2015.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import co.edu.sena.jonathan.events2015.EventsApplication;

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
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
