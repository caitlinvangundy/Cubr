package mobileapps.cse5236.cubr;

/**
 * Created by Caitlin on 3/27/2015.
 */

public class Game {
    private Cube cube;
    private enum STATE {Inactive, Active, Won};
    private STATE gameState = STATE.Inactive;
    private int playCount = 0;

    public Game(Cube cb) {
        gameState = STATE.Active;
        cube = cb;
    }

    public boolean isActive() {
        return gameState == STATE.Active;
    }

    public boolean isWon() {
        return gameState == STATE.Won;
    }

    public void checkResultAndSetState() {
        if (allSidesComplete()) {
            gameState = STATE.Won;
        }
    }

    private boolean allSidesComplete(){
        return checkFace(cube.getCubeView().getCurrentFace())
                && checkFace(cube.getCubeView().getTopFace())
                && checkFace(cube.getCubeView().getBottomFace())
                && checkFace(cube.getCubeView().getLeftFace())
                && checkFace(cube.getCubeView().getRightFace())
                && checkFace(cube.getCubeView().getBackFace());
    }

    private boolean checkFace(Face face){
        int color = face.rows.get(0).squares.get(0).color;
        return (color == face.rows.get(0).squares.get(1).color)
                && (color == face.rows.get(1).squares.get(0).color)
                && (color == face.rows.get(1).squares.get(1).color);
    }
}