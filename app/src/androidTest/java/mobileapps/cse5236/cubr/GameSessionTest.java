package mobileapps.cse5236.cubr;

import android.test.InstrumentationTestCase;

/**
 * Created by Caitlin on 4/10/2015.
 */
public class GameSessionTest extends InstrumentationTestCase {
    private GameSession gameSession;

    public void testInstantiation() {
        gameSession = new GameSession();
        assertNotNull(gameSession);
    }
}
