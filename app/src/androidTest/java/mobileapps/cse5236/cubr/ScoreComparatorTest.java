package mobileapps.cse5236.cubr;

import android.test.InstrumentationTestCase;

/**
 * Created by Caitlin on 4/8/2015.
 */
public class ScoreComparatorTest extends InstrumentationTestCase {
    public ScoreComparator scoreComparator;
    public Score score1;
    public Score score2;

    private void setup(){
        scoreComparator = new ScoreComparator();
        score1 = new Score(5);
        score2 = new Score(1);
    }

    public void testCompare(){
        setup();
        //Test score1 > score2, returns 1 if it is.
        assertEquals(1,scoreComparator.compare(score1,score2));

        //Test score2 > score1, returns -1 if it is.
        assertEquals(-1,scoreComparator.compare(score2,score1));

        //Test score1 = score1, returns 0 if it is.
        assertEquals(0,scoreComparator.compare(score1,score1));
    }
}
