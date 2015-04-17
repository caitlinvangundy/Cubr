package mobileapps.cse5236.cubr;

/**
 * Created by Caitlin on 3/27/2015.
 */

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.text.format.Time;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ImageView;

import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class GameSession extends Activity {
    private Cube cube;
    private Game activeGame = null;
    private boolean isColorBlindModeOn = false;
    private ImageView topLeft;
    private ImageView topRight;
    private ImageView bottomLeft;
    private ImageView bottomRight;
    private ShakeListener mShaker;
    private Timer timer;
    private TextView timerView;
    private String path;
    private ScoreManager manager;
    private Context context;

    private CallbackManager callbackManager;
    private ShareDialog shareDialog;

    Handler timerHandler = new Handler();
    Runnable timerRunnable = new Runnable() {

        @Override
        public void run() {
            timerView.setText(timer.toString());
            timerHandler.postDelayed(this, 100);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rubix_cube);

        playNewGame();
        timerView = (TextView) findViewById(R.id.timer);
        timerHandler.postDelayed(timerRunnable, 0);
        setupButtons();
        setupShaker();

        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        shareDialog = new ShareDialog(this);

        File external = getFilesDir();
        path = external.getPath();
        manager = new ScoreManager(this);
        System.out.println("NEW SCOREMANAGER HAS BEEN MADE");
        context = this;
    }

    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    private void setupShaker() {
        mShaker = new ShakeListener(this);
        mShaker.setOnShakeListener(new ShakeListener.OnShakeListener() {
            public void onShake() {
                timer = new Timer();
                timer.start();
                resetCube();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        System.out.println("onResume");
        if(!activeGame.isWon()) {
            timer.start();
        }
        mShaker.resume();

        // Logs 'install' and 'app activate' App Events.
        AppEventsLogger.activateApp(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        System.out.println("onStop");
    }

    @Override
    public void onPause() {
        super.onPause();
        System.out.println("onPause");
        timer.stop();
        mShaker.pause();

        // Logs 'app deactivate' App Event.
        AppEventsLogger.deactivateApp(this);
    }

    @Override
    public void onDestroy() {
        System.out.println("onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    private void playNewGame() {
        timer = new Timer();
        timer.start();
        topLeft = (ImageView) findViewById(R.id.topLeft);
        topRight = (ImageView) findViewById(R.id.topRight);
        bottomLeft = (ImageView) findViewById(R.id.bottomLeft);
        bottomRight = (ImageView) findViewById(R.id.bottomRight);

        cube = new Cube();
        cube.getCubeView().getCurrentFace().rows.get(0).squares.get(0).imageView = topLeft;
        cube.getCubeView().getCurrentFace().rows.get(0).squares.get(1).imageView = topRight;
        cube.getCubeView().getCurrentFace().rows.get(1).squares.get(0).imageView = bottomLeft;
        cube.getCubeView().getCurrentFace().rows.get(1).squares.get(1).imageView = bottomRight;
        activeGame = new Game(cube);
        cube.rotateColumn(0, "Up");//resetCube();

        applyColorOrImageChanges();
    }

    private void applyColorOrImageChanges() {
        if(isColorBlindModeOn){
            setImage();
        } else {
            setCurrentColor();
        }
    }

    private void resetCube(){
        Random rand = new Random();
        int n = rand.nextInt(4);
        for(int i = 0; i < n; i++){
            cube.rotateRow(0, "Right");
        }
        n = rand.nextInt(4);
        for(int i = 0; i < n; i++){
            cube.rotateColumn(1, "Up");
        }
        n = rand.nextInt(4);
        for(int i = 0; i < n; i++){
            cube.rotateRow(1, "Left");
        }
        n = rand.nextInt(4);
        for(int i = 0; i < n; i++){
            cube.rotateColumn(0, "Down");
        }
        applyColorOrImageChanges();
    }

    private void setImage() {
        String image = cube.getCubeView().getCurrentFace().rows.get(0).squares.get(0).image;
        setImageFromCurrentImageValue(image, topLeft);
        image = cube.getCubeView().getCurrentFace().rows.get(0).squares.get(1).image;
        setImageFromCurrentImageValue(image, topRight);
        image = cube.getCubeView().getCurrentFace().rows.get(1).squares.get(0).image;
        setImageFromCurrentImageValue(image, bottomLeft);
        image = cube.getCubeView().getCurrentFace().rows.get(1).squares.get(1).image;
        setImageFromCurrentImageValue(image, bottomRight);
    }

    private void setImageFromCurrentImageValue(String image, ImageView iv) {
        if (image.equals("circle")) {
            iv.setImageResource(R.drawable.circle);

        } else if (image.equals("heart")) {
            iv.setImageResource(R.drawable.heart);

        } else if (image.equals("square")) {
            iv.setImageResource(R.drawable.square);

        } else if (image.equals("star")) {
            iv.setImageResource(R.drawable.star);

        } else if (image.equals("triangle")) {
            iv.setImageResource(R.drawable.triangle);

        } else if (image.equals("x")) {
            iv.setImageResource(R.drawable.x);

        } else {
            System.out.println("Incorrect image");
        }
    }

    private void setCurrentColor() {
        topLeft.setImageDrawable(null);
        topRight.setImageDrawable(null);
        bottomLeft.setImageDrawable(null);
        bottomRight.setImageDrawable(null);
        cube.getCubeView().getCurrentFace().rows.get(0).squares.get(0).imageView = topLeft;
        cube.getCubeView().getCurrentFace().rows.get(0).squares.get(1).imageView = topRight;
        cube.getCubeView().getCurrentFace().rows.get(1).squares.get(0).imageView = bottomLeft;
        cube.getCubeView().getCurrentFace().rows.get(1).squares.get(1).imageView = bottomRight;
        topLeft.setBackgroundColor(cube.getCubeView().getCurrentFace().rows.get(0).squares.get(0).color);
        topRight.setBackgroundColor(cube.getCubeView().getCurrentFace().rows.get(0).squares.get(1).color);
        bottomLeft.setBackgroundColor(cube.getCubeView().getCurrentFace().rows.get(1).squares.get(0).color);
        bottomRight.setBackgroundColor(cube.getCubeView().getCurrentFace().rows.get(1).squares.get(1).color);
    }

    private void setupButtons() {
        Button exitButton = (Button) findViewById(R.id.exitButton);
        exitButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                System.out.println("Exit button clicked");
                finish();
                System.exit(0);
            }
        });

        final Button highScoresButton = (Button) findViewById(R.id.highScoreButton);

        highScoresButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("High scores button clicked");

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setCancelable(true);
                builder.setTitle("High Scores List");
                ArrayList<Score> highScoreArray = manager.getHighScores();
                int arraySize = highScoreArray.size();
                String[] stringArrayScores = new String[arraySize];

                for(int i=0; i<stringArrayScores.length; i++){
                    String time, textScore;
                    int listNum = i+1;

                    System.out.println("Time: " + highScoreArray.get(i).getPrettyScore());
                    System.out.println("HighScoresSize: " + arraySize);
                    textScore = (listNum) + ". " + highScoreArray.get(i).getPrettyScore();
                    stringArrayScores[i] = textScore;
                }
                builder.setItems(stringArrayScores, new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which){

                    }
                }).show();
            }
        });

        Button facebook = (Button) findViewById(R.id.facebook);
        facebook.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                System.out.println("Share button clicked");
                if (ShareDialog.canShow(ShareLinkContent.class)) {
                    Score score = manager.getCurrentHighScore();
                    String currentHighScore = "";
                    if (null != score){
                        currentHighScore = score.getPrettyScore();
                    }
                    ShareLinkContent linkContent = new ShareLinkContent.Builder()
                            .setContentTitle("I beat Cubr!")
                            .setContentDescription(
                                    "I got a new high score on Cubr. My new best time is: " + currentHighScore)
                            .setContentUrl((Uri.parse("http://web.cse.ohio-state.edu/~champion/5236/")))
                            .build();

                    shareDialog.show(linkContent);
                }
            }
        });

        Button colorBlindButton = (Button) findViewById(R.id.colorBlindButton);
        colorBlindButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                System.out.println("Color blind button clicked");
                if(isColorBlindModeOn){
                    isColorBlindModeOn = false;
                } else {
                    isColorBlindModeOn = true;
                }
                applyColorOrImageChanges();
            }
        });

        Button upButton = (Button) findViewById(R.id.upButton);
        upButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                System.out.println("Up button clicked");
                cube.changeView(cube.getCubeView().getBottomFace());
                applyColorOrImageChanges();
            }
        });

        Button leftButton = (Button) findViewById(R.id.leftButton);
        leftButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                System.out.println("Left button clicked");
                cube.changeView(cube.getCubeView().getRightFace());
                applyColorOrImageChanges();
            }
        });

        Button downButton = (Button) findViewById(R.id.downButton);
        downButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                System.out.println("Down button clicked");
                cube.changeView(cube.getCubeView().getTopFace());
                applyColorOrImageChanges();
            }
        });

        Button rightButton = (Button) findViewById(R.id.rightButton);
        rightButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                System.out.println("Right button clicked");
                cube.changeView(cube.getCubeView().getLeftFace());
                applyColorOrImageChanges();
            }
        });

        Button rowOneButton = (Button) findViewById(R.id.rowOneButton);
        rowOneButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                System.out.println("Row one button clicked");
                cube.rotateRow(0, "Right");

                applyColorOrImageChanges();
                proceedToFinish();
            }
        });

        Button rowTwoButton = (Button) findViewById(R.id.rowTwoButton);
        rowTwoButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                System.out.println("Row two button clicked");
                cube.rotateRow(1, "Right");

                applyColorOrImageChanges();
                proceedToFinish();
            }
        });

        Button rowThreeButton = (Button) findViewById(R.id.rowThreeButton);
        rowThreeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                System.out.println("Row three button clicked");
                cube.rotateRow(0, "Left");

                applyColorOrImageChanges();
                proceedToFinish();
            }

        });

        Button rowFourButton = (Button) findViewById(R.id.rowFourButton);
        rowFourButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                System.out.println("Row four button clicked");
                cube.rotateRow(1, "Left");

                applyColorOrImageChanges();
                proceedToFinish();
            }
        });

        Button columnOneButton = (Button) findViewById(R.id.columnOneButton);
        columnOneButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                System.out.println("Column one button clicked");
                cube.rotateColumn(0, "Up");

                applyColorOrImageChanges();
                proceedToFinish();
            }
        });

        Button columnTwoButton = (Button) findViewById(R.id.columnTwoButton);
        columnTwoButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                System.out.println("Column two button clicked");
                cube.rotateColumn(1, "Up");

                applyColorOrImageChanges();
                proceedToFinish();
            }
        });

        Button columnThreeButton = (Button) findViewById(R.id.columnThreeButton);
        columnThreeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                System.out.println("Column three button clicked");
                cube.rotateColumn(0, "Down");

                applyColorOrImageChanges();
                proceedToFinish();
            }
        });

        Button columnFourButton = (Button) findViewById(R.id.columnFourButton);
        columnFourButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                System.out.println("Column four button clicked");
                cube.rotateColumn(1, "Down");

                applyColorOrImageChanges();
                proceedToFinish();
            }
        });
    }

    private void proceedToFinish() {
        String alertMessage = null;
        if (activeGame.isWon()) {
            alertMessage = " You've won!";
            timer.stop();

            Score newHighScore = new Score(timer.elapsedTime);
            manager.addHighScore(newHighScore);
        } else {
            return;
        }
        new AlertDialog.Builder(this)
                .setTitle(alertMessage)
                .setMessage("Play another game?")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        playNewGame();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .show();

    }
}

