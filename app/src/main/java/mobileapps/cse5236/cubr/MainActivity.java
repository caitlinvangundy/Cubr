package mobileapps.cse5236.cubr;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;

import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;

public class MainActivity extends FragmentActivity {
    private Cube cube;
    CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main);
        System.out.println("onCreate");

        cube = new Cube();

        Button exitButton = (Button) findViewById(R.id.exitButton);
        exitButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                System.out.println("Exit button clicked");
                finish();
                System.exit(0);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onResume(){
        System.out.println("onResume");
        super.onResume();
    }

    @Override
    public void onPause(){
        System.out.println("onPause");
        super.onPause();
    }

    @Override
    public void onStop(){
        System.out.println("onStop");
        super.onStop();
    }

    @Override
    public void onDestroy(){
        System.out.println("onDestroy");
        super.onDestroy();
    }
}
