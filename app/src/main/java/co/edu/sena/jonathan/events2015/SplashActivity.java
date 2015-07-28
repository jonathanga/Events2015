package co.edu.sena.jonathan.events2015;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class SplashActivity extends Activity implements Runnable{

    private final int TIME_THREAD=3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread thread=new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(TIME_THREAD);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Intent i=new Intent(SplashActivity.this,MainActivity.class);
        startActivity(i);
        finish();
    }
}
