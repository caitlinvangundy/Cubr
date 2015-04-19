package mobileapps.cse5236.cubr;

import android.graphics.Color;
import android.test.InstrumentationTestCase;

/**
 * Created by Caitlin on 4/8/2015.
 */
public class CubeViewTest extends InstrumentationTestCase {
    public CubeView cubeView;

    private  void setup(){
        cubeView = new CubeView();
    }

    public void testRotateColumn() {
        setup();
        cubeView.rotateColumn(0, "Up");

        assertEquals(Color.BLUE, cubeView.getCurrentFace().rows.get(0).squares.get(0).color);
        assertEquals(Color.BLUE, cubeView.getCurrentFace().rows.get(1).squares.get(0).color);
        assertEquals(Color.RED, cubeView.getCurrentFace().rows.get(0).squares.get(1).color);
        assertEquals(Color.RED, cubeView.getCurrentFace().rows.get(1).squares.get(1).color);
    }

    public void testRotateRow() {
        setup();
        cubeView.rotateRow(0, "Left");

        assertEquals(Color.MAGENTA, cubeView.getCurrentFace().rows.get(0).squares.get(0).color);
        assertEquals(Color.MAGENTA, cubeView.getCurrentFace().rows.get(0).squares.get(1).color);
        assertEquals(Color.RED, cubeView.getCurrentFace().rows.get(1).squares.get(0).color);
        assertEquals(Color.RED, cubeView.getCurrentFace().rows.get(1).squares.get(1).color);
    }

    public void testChangeView() {
        setup();
        Face face = new Face(1);
        cubeView.changeView(face);

        assertEquals(Color.MAGENTA, cubeView.getCurrentFace().rows.get(0).squares.get(0).color);
    }
}
