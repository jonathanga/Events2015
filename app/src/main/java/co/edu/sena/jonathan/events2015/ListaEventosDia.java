package co.edu.sena.jonathan.events2015;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.mixpanel.android.mpmetrics.MixpanelAPI;

import co.edu.sena.jonathan.events2015.adapters.AdaptadorLista;


public class ListaEventosDia extends Activity {

    ListView lstEventos;
    Button btAgendarTodo;
    EventsApplication application;
    AdaptadorLista adapterLista;

    public static int pos=0;


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
    }

    public void agendarEvento(int position){
        MixpanelAPI mixpanelAPI = MixpanelAPI.getInstance(this, "33fda110df511f50c5eed8a357b1d44c");
        MixpanelAPI.People people= mixpanelAPI.getPeople();
        people.identify("usuarioWS"+application.getListaEventos().get(position).getNombre());
        people.initPushHandling("214490295855");

        notificacionExtra(position);
    }

    private void notificacionExtra(int pos) {
        NotificationCompat.Builder mBuilder2 = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.sin_agendar)
                .setContentTitle("Event tracker")
                .setContentText("Events received");
        NotificationCompat.InboxStyle inboxStyle =
                new NotificationCompat.InboxStyle();
        String[] events = new String[6];
// Sets a title for the Inbox in expanded layout
        inboxStyle.setBigContentTitle("Event tracker details:");
        //...
// Moves events into the expanded layout
        for (int i=0; i < events.length; i++) {

            inboxStyle.addLine(events[i]);
        }
// Moves the expanded layout object into the notification object.
        mBuilder2.setStyle(inboxStyle);

        //--------------------********************************************
        mBuilder2 =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.sin_agendar)
                        .setContentTitle(application.getListaEventos().get(pos).getNombre())
                        .setContentText("Dia " + application.getListaEventos().get(pos).getDia() + " a las " + application.getListaEventos().get(pos).getDia());
// Creates an explicit intent for an Activity in your app
        Intent resultIntent = new Intent(this, DetalleActivity.class);

// The stack builder object will contain an artificial back stack for the
// started Activity.
// This ensures that navigating backward from the Activity leads out of
// your application to the Home screen.
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
// Adds the back stack for the Intent (but not the Intent itself)
        stackBuilder.addParentStack(DetalleActivity.class);
// Adds the Intent that starts the Activity to the top of the stack
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        mBuilder2.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
// mId allows you to update the notification later on.
        mNotificationManager.notify(0, mBuilder2.build());
    }

}