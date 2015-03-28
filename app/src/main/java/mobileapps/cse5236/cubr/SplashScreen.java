package mobileapps.cse5236.cubr;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SplashScreen extends Activity {
    private Thread splashThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        final SplashScreen splashScreen = this;

        splashThread = new Thread() {
            @Override
            public void run() {
                try {
                    synchronized (this) {
                        wait(5000);
                    }
                } catch (InterruptedException ex) {
                    System.exit(-1);
                }

                finish();

                Intent intent = new Intent();
                intent.setClass(splashScreen, GameSession.class);
                startActivity(intent);
            }
        };
        splashThread.start();
    }
}