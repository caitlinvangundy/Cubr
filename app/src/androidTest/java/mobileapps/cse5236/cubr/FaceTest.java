package mobileapps.cse5236.cubr;

import android.test.InstrumentationTestCase;
/**
 * Created by Caitlin on 4/8/2015.
 */
public class FaceTest extends InstrumentationTestCase{
    private Face front;

    public void setup(){
        front = new Face(0);
    }

    public void testRotateClockwise() {
    }

    public void testRotateCounterClockwise() {

    }

    public void testGetFaceIndex(){
        setup();
        int index = front.getFaceIndex();
        assertEquals(0, index);
    }

    public void testGetType() {
        setup();
        String type = front.getType();
        assertEquals("Current", type);
    }
}
