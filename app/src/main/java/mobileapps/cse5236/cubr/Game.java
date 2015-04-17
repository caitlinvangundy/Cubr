package mobileapps.cse5236.cubr;

import android.os.AsyncTask;

/**
 * Created by Caitlin on 3/27/2015.
 */

public class Game extends AsyncTask<Void, Void, Void> {
    private Cube cube;
    private enum STATE {Inactive, Active, Won};
    private STATE gameState = STATE.Inactive;

    public Game(Cube cb) {
        gameState = STATE.Active;
        cube = cb;
    }

    @Override
    protected Void doInBackground(Void... params) {
        checkResultAndSetState();
        return null;
    }

    public boolean isWon() {
        doInBackground(null);
        return gameState == STATE.Won;
    }

    private void checkResultAndSetState() {
        if (allSidesComplete()) {
            gameState = STATE.Won;
        } else {
            gameState = STATE.Active;
        }
    }

    private boolean allSidesComplete() {
        return checkFace(cube.getCubeView().getCurrentFace())
                && checkFace(cube.getCubeView().getTopFace())
                && checkFace(cube.getCubeView().getBottomFace())
                && checkFace(cube.getCubeView().getLeftFace())
                && checkFace(cube.getCubeView().getRightFace())
                && checkFace(cube.getCubeView().getBackFace());
    }

    private boolean checkFace(Face face) {
        int color = face.rows.get(0).squares.get(0).color;
        return (color == face.rows.get(0).squares.get(1).color)
                && (color == face.rows.get(1).squares.get(0).color)
                && (color == face.rows.get(1).squares.get(1).color);
    }
}