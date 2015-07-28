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
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.plus.People;
import com.mixpanel.android.mpmetrics.MixpanelAPI;


public class DetalleActivity extends Activity {

    private MixpanelAPI mixpanelAPI;
    EventsApplication application;
    TextView nombre,dia,lugar,hora;

    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        pos=ListaEventosDia.pos;
        //pos=0;
 //       Toast.makeText(this,pos,Toast.LENGTH_SHORT).show();
        application= (EventsApplication) getApplicationContext();
        nombre= (TextView) findViewById(R.id.detalle_txt_nombre);
        dia= (TextView) findViewById(R.id.detalle_txt_dia);
        lugar= (TextView) findViewById(R.id.detalle_txt_lugar);
        hora= (TextView) findViewById(R.id.detalle_txt_hora);

        llenarDetalle();


    }

    private void llenarDetalle() {
        nombre.setText(""+application.getListaEventos().get(pos).getNombre());
        dia.setText(""+application.getListaEventos().get(pos).getDia());
        lugar.setText(""+application.getListaEventos().get(pos).getUbiacion());
        hora.setText(""+application.getListaEventos().get(pos).getStart_time());

        submitNotification(null);


    }


    public void submitNotification(View view) {
        mixpanelAPI=MixpanelAPI.getInstance(this,"33fda110df511f50c5eed8a357b1d44c");
        MixpanelAPI.People people= mixpanelAPI.getPeople();
        people.identify("usuarioWS" + application.getListaEventos().get(pos).getNombre());
        people.initPushHandling("214490295855");

        notificacionExtra();
    }

    private void notificacionExtra() {
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