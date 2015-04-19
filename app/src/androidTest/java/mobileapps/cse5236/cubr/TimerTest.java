package mobileapps.cse5236.cubr;

import android.test.InstrumentationTestCase;

/**
 * Created by Caitlin on 4/8/2015.
 */
public class TimerTest extends InstrumentationTestCase {
    private Timer timer;

    private void setup(){
        timer = new Timer();
    }

    public void testStartAndUpdate() throws InterruptedException {
        setup();
        timer.start();
        long time1 = timer.currentTime;
        boolean updated = timer.update();

        assertTrue(time1 != 0);
        assertTrue(updated);

        Thread.sleep(100);
        timer.update();
        long time2 = timer.currentTime;

        assertTrue(time2 != time1);
    }

    public void testStop() {
        setup();
        timer.stop();
        boolean updated = timer.update();

        assertEquals(updated, false);
    }

    public void testToString() {
        setup();
        String zeroString = "00:00:00.0";
        String returnString = timer.toString();

        assertEquals(returnString, zeroString);
    }
}
