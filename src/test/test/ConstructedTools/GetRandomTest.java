package ConstructedTools;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GetRandomTest {
    /**
     * Method under test: {@link GetRandom#getRandomNum()}
     */
    @Test
    void testGetRandomNum() {
        assertEquals(0, GetRandom.getRandomNum());
    }



    /**
     * Method under test: {@link GetRandom#getRandomOpe()}
     */
    @Test
    void testGetRandomOpe2() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        GetRandom.getRandomOpe();
    }

    /**
     * Method under test: {@link GetRandom#getRandomFrac()}
     */
    @Test
    void testGetRandomFrac() {
        Frac actualRandomFrac = GetRandom.getRandomFrac();
        assertEquals(0, actualRandomFrac.numerator);
        assertEquals(0, actualRandomFrac.denominator);
    }
}

