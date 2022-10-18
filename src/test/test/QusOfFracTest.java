import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

class QusOfFracTest {

    @Test
    public void ExcrptionThrown()  {
    boolean flag=false;
        try {
            QusOfFrac qus = new QusOfFrac(3);
        }
        catch (Exception e)
        {
            flag=true;
        }
        assertTrue(flag);

    }

    /**
    * Settings Tester.
    *
    * @author <Authors name>
    * @since <pre>10月 18, 2022</pre>
    * @version 1.0
    */
    public static class SettingsTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
    *
    * Method: setSettings(int maxInt, double maxFrac, int maxDenominator)
    *
    */
    @org.junit.Test
    public void testSetSettings() throws Exception {
    //TODO: Test goes here...
    }

    /**
    *
    * Method: getGcd(int x, int y)
    *
    */
    @org.junit.Test
    public void testGetGcd() throws Exception {
    //TODO: Test goes here...
    }


    }
}

