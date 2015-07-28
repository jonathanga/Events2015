package co.edu.sena.jonathan.events2015;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.plus.People;
import com.mixpanel.android.mpmetrics.MixpanelAPI;


public class DetalleActivity extends Activity {

    private MixpanelAPI mixpanelAPI;
    EventsApplication application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

    }


    public void submitNotification(View view) {
        mixpanelAPI=MixpanelAPI.getInstance(this,"33fda110df511f50c5eed8a357b1d44c");
        MixpanelAPI.People people= mixpanelAPI.getPeople();
        people.identify("usuarioWS"+application.getListaEventos().get(0).getNombre());
        people.initPushHandling("214490295855");
    }
}