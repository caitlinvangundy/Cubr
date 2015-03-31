package mobileapps.cse5236.cubr;

/**
 * Created by Caitlin on 3/27/2015.
 */

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class GameSession extends Activity {
    private Cube cube;
    private Game activeGame = null;
    private boolean isColorBlindModeOn = false;
    private ImageView topLeft;
    private ImageView topRight;
    private ImageView bottomLeft;
    private ImageView bottomRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.rubix_cube);
        playNewGame();
        setupButtons();
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

        Button upButton = (Button) findViewById(R.id.upButton);
        upButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                System.out.println("Up button clicked");
                cube.changeView(cube.getCubeView().getBottomFace());

                if(isColorBlindModeOn){
                    setImage();
                } else {
                    setCurrentColor();
                }
            }
        });

        Button leftButton = (Button) findViewById(R.id.leftButton);
        leftButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                System.out.println("Left button clicked");
                cube.changeView(cube.getCubeView().getRightFace());

                if(isColorBlindModeOn){
                    setImage();
                } else {
                    setCurrentColor();
                }
            }
        });

        Button downButton = (Button) findViewById(R.id.downButton);
        downButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                System.out.println("Down button clicked");
                cube.changeView(cube.getCubeView().getTopFace());

                if(isColorBlindModeOn){
                    setImage();
                } else {
                    setCurrentColor();
                }
            }
        });

        Button rightButton = (Button) findViewById(R.id.rightButton);
        rightButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                System.out.println("Right button clicked");
                cube.changeView(cube.getCubeView().getLeftFace());

                if(isColorBlindModeOn){
                    setImage();
                } else {
                    setCurrentColor();
                }
            }
        });

        Button rowOneButton = (Button) findViewById(R.id.rowOneButton);
        rowOneButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                System.out.println("Row one button clicked");
                cube.rotateRow(0, "Right");
                cube.getCubeView().getTopFace().rotateCounterClockwise();

                if(isColorBlindModeOn){
                    setImage();
                } else {
                    setCurrentColor();
                }
            }
        });

        Button rowTwoButton = (Button) findViewById(R.id.rowTwoButton);
        rowTwoButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                System.out.println("Row two button clicked");
                cube.rotateRow(1, "Right");
                cube.getCubeView().getBottomFace().rotateClockwise();

                if(isColorBlindModeOn){
                    setImage();
                } else {
                    setCurrentColor();
                }
            }
        });

        Button rowThreeButton = (Button) findViewById(R.id.rowThreeButton);
        rowThreeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                System.out.println("Row three button clicked");
                cube.rotateRow(0, "Left");
                cube.getCubeView().getTopFace().rotateClockwise();

                if(isColorBlindModeOn){
                    setImage();
                } else {
                    setCurrentColor();
                }
            }
        });

        Button rowFourButton = (Button) findViewById(R.id.rowFourButton);
        rowFourButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                System.out.println("Row four button clicked");
                cube.rotateRow(1, "Left");
                cube.getCubeView().getBottomFace().rotateCounterClockwise();

                if(isColorBlindModeOn){
                    setImage();
                } else {
                    setCurrentColor();
                }
            }
        });

        Button columnOneButton = (Button) findViewById(R.id.columnOneButton);
        columnOneButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                System.out.println("Column one button clicked");
                cube.rotateColumn(0, "Up");
                cube.getCubeView().getLeftFace().rotateCounterClockwise();

                if(isColorBlindModeOn){
                    setImage();
                } else {
                    setCurrentColor();
                }
            }
        });

        Button columnTwoButton = (Button) findViewById(R.id.columnTwoButton);
        columnTwoButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                System.out.println("Column two button clicked");
                cube.rotateColumn(1, "Up");
                cube.getCubeView().getRightFace().rotateClockwise();

                if(isColorBlindModeOn){
                    setImage();
                } else {
                    setCurrentColor();
                }
            }
        });

        Button columnThreeButton = (Button) findViewById(R.id.columnThreeButton);
        columnThreeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                System.out.println("Column three button clicked");
                cube.rotateColumn(0, "Down");
                cube.getCubeView().getLeftFace().rotateClockwise();

                if(isColorBlindModeOn){
                    setImage();
                } else {
                    setCurrentColor();
                }
            }
        });

        Button columnFourButton = (Button) findViewById(R.id.columnFourButton);
        columnFourButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                System.out.println("Column four button clicked");
                cube.rotateColumn(1, "Down");
                cube.getCubeView().getRightFace().rotateCounterClockwise();

                if(isColorBlindModeOn){
                    setImage();
                } else {
                    setCurrentColor();
                }
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        playNewGame();
    }

    @Override
    public void onStop() {
        System.out.println("onStop");
        super.onStop();
    }

    @Override
    public void onDestroy() {
        System.out.println("onDestroy");
        super.onDestroy();
    }

    private void playNewGame() {
        topLeft = (ImageView) findViewById(R.id.topLeft);
        topRight = (ImageView) findViewById(R.id.topRight);
        bottomLeft = (ImageView) findViewById(R.id.bottomLeft);
        bottomRight = (ImageView) findViewById(R.id.bottomRight);

        cube = new Cube();
        cube.getCubeView().getCurrentFace().rows.get(0).squares.get(0).imageView = topLeft;
        cube.getCubeView().getCurrentFace().rows.get(0).squares.get(1).imageView = topRight;
        cube.getCubeView().getCurrentFace().rows.get(1).squares.get(0).imageView = bottomLeft;
        cube.getCubeView().getCurrentFace().rows.get(1).squares.get(1).imageView = bottomRight;

        applyColorOrImageChanges();

        // TODO When phone is shaken, run resetCube();
        resetCube();
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
        switch(image){
                case "circle":
                iv.setImageResource(R.drawable.circle);
                break;
            case "heart":
                iv.setImageResource(R.drawable.heart);
                break;
            case "square":
                iv.setImageResource(R.drawable.square);
                break;
            case "star":
                iv.setImageResource(R.drawable.star);
                break;
            case "triangle":
                iv.setImageResource(R.drawable.triangle);
                break;
            case "x":
                iv.setImageResource(R.drawable.x);
                break;
            default:
                System.out.println("Incorrect image");
        }
    }

    private void setCurrentColor() {
        cube.getCubeView().getCurrentFace().rows.get(0).squares.get(0).imageView = topLeft;
        cube.getCubeView().getCurrentFace().rows.get(0).squares.get(1).imageView = topRight;
        cube.getCubeView().getCurrentFace().rows.get(1).squares.get(0).imageView = bottomLeft;
        cube.getCubeView().getCurrentFace().rows.get(1).squares.get(1).imageView = bottomRight;
        topLeft.setBackgroundColor(cube.getCubeView().getCurrentFace().rows.get(0).squares.get(0).color);
        topRight.setBackgroundColor(cube.getCubeView().getCurrentFace().rows.get(0).squares.get(1).color);
        bottomLeft.setBackgroundColor(cube.getCubeView().getCurrentFace().rows.get(1).squares.get(0).color);
        bottomRight.setBackgroundColor(cube.getCubeView().getCurrentFace().rows.get(1).squares.get(1).color);
    }
//
//    private void setPlayers(Game theGame){
//        firstPlayerName = Settings.getName(this);
//        theGame.setPlayerNames(firstPlayerName, firstPlayerName);
//    }


    protected void humanTakesATurn(int x, int y) {/* human's turn */
//        System.out.println("Thread ID in humanTakesATurn:" + Thread.currentThread().getId());
//        boolean successfulPlay = activeGame.play(x,y);
//        if (successfulPlay){
//            cubeView.placeSymbol(x,y); /* Update the display */
//            if(activeGame.isActive()){
//                cubeView.setGameStatus(activeGame.getCurrentPlayerName() + " to play.");
//            } else {
//                proceedToFinish();
//            }
//        }
    }

    private void quitGame() {
        new AlertDialog.Builder(this)
                .setTitle("Exit")
                .setMessage("Abandon this game?")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .show();
    }

    private void proceedToFinish() {
        String winningPlayerName = null;

        String alertMessage = null;
        if (activeGame.isWon()) {
            alertMessage = " You've won!";
            //cubeView.setGameStatus(alertMessage);
            //cubeView.showScores(firstPlayerName, scorePlayerOne, secondPlayerName, scorePlayerTwo);
        } else if (activeGame.isDrawn()) {
            alertMessage = "DRAW!";
            //cubeView.setGameStatus(alertMessage);
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

    public boolean onCreateOptionsMenu(Menu menu) {
//        super.onCreateOptionsMenu(menu);
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menu_ingame, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.menu_help:
//                startActivity(new Intent(this, Help.class));
//                return true;
//            case R.id.menu_exit:
//                quitGame();
//                return true;
//        }
        return false;
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save session score
        //outState.putInt(SCOREPLAYERONEKEY, scorePlayerOne);
        // Save turn
        //Save board
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Restore session score
        //scorePlayerOne = savedInstanceState.getInt(SCOREPLAYERONEKEY);
        // Restore turn

        // Restore board
    }
}

