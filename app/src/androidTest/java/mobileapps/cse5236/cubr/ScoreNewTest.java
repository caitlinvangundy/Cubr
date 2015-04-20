package mobileapps.cse5236.cubr;

import android.test.InstrumentationTestCase;

/**
 * Created by timryan on 4/20/15.
 */
public class ScoreNewTest extends InstrumentationTestCase{
    public long time;
    public Score score;

    private void setup(){
        time = 010101001;
        score = new Score(time);
    }
    public void testGetScore() {
        setup();
        assertEquals(010101001, score.getScore());
    }
    public void testGetPrettyScore(){
        setup();
        assertEquals("00:35:30.433",score.getPrettyScore());
    }
}
