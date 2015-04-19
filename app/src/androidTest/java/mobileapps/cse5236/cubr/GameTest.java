package mobileapps.cse5236.cubr;

import android.test.InstrumentationTestCase;

/**
 * Created by Caitlin on 4/8/2015.
 */
public class GameTest extends InstrumentationTestCase {
    Cube cube;
    Game game;

    private void setupSolvedCube() {
        cube = new Cube();
        game = new Game(cube);
    }

    private void setupUnsolvedCube() {
        cube = new Cube();
        cube.rotateRow(0,"Left");
        game = new Game(cube);
    }

    public void testIsWon() {
        setupSolvedCube();
        boolean isWon = game.isWon();
        assertTrue(isWon);

        setupUnsolvedCube();
        isWon = game.isWon();
        assertEquals(isWon, false);
    }
}
