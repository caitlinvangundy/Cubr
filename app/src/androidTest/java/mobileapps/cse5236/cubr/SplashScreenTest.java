package mobileapps.cse5236.cubr;

import android.os.Bundle;
import android.test.InstrumentationTestCase;

/**
 * Created by Caitlin on 4/10/2015.
 */
public class SplashScreenTest extends InstrumentationTestCase {
    private SplashScreen splashScreen;

    public void testInstantiation() {
        splashScreen = new SplashScreen();
        assertNotNull(splashScreen);
    }
}
