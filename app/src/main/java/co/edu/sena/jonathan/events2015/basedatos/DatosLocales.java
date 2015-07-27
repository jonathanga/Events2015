package co.edu.sena.jonathan.events2015.basedatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
            KEY_LOCATION + " TEXT);");
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
}
