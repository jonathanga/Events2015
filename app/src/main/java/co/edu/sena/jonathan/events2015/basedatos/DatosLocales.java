package co.edu.sena.jonathan.events2015.basedatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import co.edu.sena.jonathan.events2015.R;

/**
 * Created by CARMANU on 27/07/2015.
 */
public class DatosLocales  {

    private static final String BD_NAME = "WS2015";
    private static final String T_EVENTO = "Evensts";

    public static final String KEY_ID = "Id_";
    public static final String KEY_NAME = "Name_";
    public static final String KEY_START_TIME = "Start_time_";
    public static final String KEY_DAY = "Day_";
    public static final String KEY_PARTICIPANTS = "Participants_";
    public static final String KEY_LOCATION = "Location_";
    public static final String KEY_STATE = "State_";

    private Context context;
    private SQLiteDatabase nBd;
    private BdHelper nHelper;

    private class BdHelper extends SQLiteOpenHelper{

        public BdHelper(Context context) {
            super(context, BD_NAME, null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TALBE " + T_EVENTO + "(" + KEY_ID + " INTEGER PRIMARY KEY, " + KEY_NAME + " TEXT, " + KEY_START_TIME + " TEXT, " + KEY_DAY + " TEXT, " + KEY_PARTICIPANTS + " TEXT, " +
            KEY_LOCATION + " TEXT, " + KEY_STATE + " INTEGER);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + T_EVENTO);
            onCreate(db);
        }
    }

    public DatosLocales(Context context) {
        this.context = context;
    }

    public void openBd(){
        nHelper = new BdHelper(context);
        nBd = nHelper.getWritableDatabase();

        if(!hayRegistros()){
            try {

                InputStream stream = context.getResources().openRawResource(R.raw.events);
                BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

                int count = 0;

                String datos;
                while ((datos = reader.readLine()) != null) {

                    String[] datosSeparados = datos.split(";");
                    if(count != 0){
                        insertarDatos(datosSeparados);
                    }
                }

            } catch (IOException e) {

                e.printStackTrace();
            }

        }
    }

    public void closeBd(){
        nHelper.close();
    }

    private void insertarDatos(String[] datosSeparados) {
        ContentValues cv = new ContentValues();

        cv.put(KEY_NAME, datosSeparados[1]);
        cv.put(KEY_START_TIME,datosSeparados[2]);
        cv.put(KEY_DAY, datosSeparados[3]);
        cv.put(KEY_PARTICIPANTS, datosSeparados[4]);
        cv.put(KEY_LOCATION, datosSeparados[5]);
        cv.put(KEY_STATE, 0);

        nBd.insert(T_EVENTO, null, cv);
    }

    private boolean hayRegistros() {

        Cursor c = nBd.rawQuery("select * from "+T_EVENTO, null);

        if(c.moveToFirst()){
            return true;
        }else {
            return false;
        }
    }
}
