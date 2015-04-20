package mobileapps.cse5236.cubr;

import android.test.InstrumentationTestCase;

/**
 * Created by Caitlin on 4/8/2015.
 */
public class ScoreManagerTest extends InstrumentationTestCase {
    public ScoreManager scoreManager;
    public void testInstantiation(){
        scoreManager = new ScoreManager(null);
        assertNotNull(scoreManager);
    }
}
