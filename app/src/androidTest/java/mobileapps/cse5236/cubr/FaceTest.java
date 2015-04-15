package mobileapps.cse5236.cubr;

import android.graphics.Color;
import android.test.InstrumentationTestCase;
/**
 * Created by Caitlin on 4/8/2015.
 */
public class FaceTest extends InstrumentationTestCase{
    private Face front;

    public void testRotateClockwise() {
        setup();
        changeColors();
        front.rotateClockwise();
        assertEquals(Color.YELLOW, front.rows.get(0).squares.get(0).color);
        assertEquals(Color.RED, front.rows.get(0).squares.get(1).color);
        assertEquals(Color.GREEN, front.rows.get(1).squares.get(0).color);
        assertEquals(Color.MAGENTA, front.rows.get(1).squares.get(1).color);
    }
    public void testRotateCounterClockwise() {
        setup();
        changeColors();
        front.rotateCounterClockwise();
        assertEquals(Color.MAGENTA, front.rows.get(0).squares.get(0).color);
        assertEquals(Color.GREEN, front.rows.get(0).squares.get(1).color);
        assertEquals(Color.RED, front.rows.get(1).squares.get(0).color);
        assertEquals(Color.YELLOW, front.rows.get(1).squares.get(1).color);
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

    private  void setup(){
        front = new Face(0);
    }

    private void changeColors() {
        front.rows.get(0).squares.get(0).color = Color.RED;
        front.rows.get(0).squares.get(1).color = Color.MAGENTA;
        front.rows.get(1).squares.get(0).color = Color.YELLOW;
        front.rows.get(1).squares.get(1).color = Color.GREEN;
    }
}
