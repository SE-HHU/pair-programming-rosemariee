package ConstructedTools;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PairCalTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testToString() {
        PairCal pc=new PairCal();
        assertNotNull(pc.toString());
    }
    @Test
    public void testToString2() {
        PairCal pc=new PairCal();
        String s=pc.toString();
        assertEquals("(",String.valueOf(s.charAt(0)));


    }
    @Test
    public void testToString3() {
        PairCal pc=new PairCal();
        String s=pc.toString();

        assertEquals(")",String.valueOf(s.charAt(s.length()-1)));

    }
}