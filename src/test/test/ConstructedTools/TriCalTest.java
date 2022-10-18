package ConstructedTools;

import org.junit.Test;

import static org.junit.Assert.*;

public class TriCalTest {

    @Test
    public void testToString() {
        TriCal pc = new TriCal();
        assertNotNull(pc.toString());
    }

    @Test
    public void testToString2() {
        TriCal pc = new TriCal();
        String s = pc.toString();
        assertEquals("(", String.valueOf(s.charAt(0)));


    }

    @Test
    public void testToString3() {
        TriCal pc = new TriCal();
        String s = pc.toString();

        assertEquals(")", String.valueOf(s.charAt(s.length() - 1)));

    }
}