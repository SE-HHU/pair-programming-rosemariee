package ConstructedTools;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SettingsTest {


    @Before
    public void setUp() throws Exception {
        Settings st = new Settings();
    }
    @Test
    public void testSetSettings() {
        Settings.setSettings(3, 10.0d, 3);
    }
    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getGcd1() {
        assertEquals(3, Settings.getGcd(3, 9));
    }

    @Test
    public void getGcd2() {
        assertEquals(2, Settings.getGcd(4, 2));
    }

    @Test
    public void getGcd3() {
        assertEquals(1, Settings.getGcd(-5, 7));
    }

    @Test
    public void getGcd4() {
        boolean flag=false;
        try {
            assertEquals(0, Settings.getGcd(0, 2));
        }
        catch (Exception e)
        {
            flag=true;
        }
        assertTrue(flag);
        }
}