package mobileapps.cse5236.cubr;

import android.test.InstrumentationTestCase;

/**
 * Created by Caitlin on 4/8/2015.
 */
public class CubeTest extends InstrumentationTestCase {
    public Cube cube;
    public void testInstantiation(){
        cube = new Cube();
        assertNotNull(cube);
    }
}
