package mobileapps.cse5236.cubr;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.test.InstrumentationTestCase;
import android.test.IsolatedContext;
import android.test.mock.MockContext;

/**
 * Created by Caitlin on 4/10/2015.
 */
public class ShakeListenerTest extends InstrumentationTestCase {
    private ShakeListener shakeListener;

    public void testInstantiation() {
        assertNull(shakeListener);
    }
}
