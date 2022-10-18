package ConstructedTools;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FracTest {
    /**
     * Method under test: {@link Frac#Frac(int)}
     */
    @Test
    void testConstructor() {
        Frac actualFrac = new Frac(2);
        assertEquals(2.0d, actualFrac.getValue());
        assertEquals(2, actualFrac.numerator);
        assertEquals(1, actualFrac.denominator);
        assertFalse(actualFrac.isLegal());
    }

    /**
     * Method under test: {@link Frac#Frac(int, int)}
     */
    @Test
    void testConstructor2() {
        Frac actualFrac = new Frac(1, 10);

        assertEquals(10.0d, actualFrac.getValue());
        assertEquals(10, actualFrac.numerator);
        assertEquals(1, actualFrac.denominator);
        assertFalse(actualFrac.isLegal());
    }

    /**
     * Method under test: {@link Frac#equals(Object)}
     */
    @Test
    void testEquals() {
        assertNotEquals(GetRandom.getRandomFrac(), null);
        assertNotEquals(GetRandom.getRandomFrac(), "Different type to Frac");
    }

    /**
     * Method under test: {@link Frac#equals(Object)}
     */
    @Test
    void testEquals2() {
        Frac randomFrac = GetRandom.getRandomFrac();
        assertEquals(randomFrac, randomFrac);
        int expectedHashCodeResult = randomFrac.hashCode();
        assertEquals(expectedHashCodeResult, randomFrac.hashCode());
    }

    /**
     * Method under test: {@link Frac#equals(Object)}
     */
    @Test
    void testEquals3() {
        Frac randomFrac = GetRandom.getRandomFrac();
        Frac randomFrac1 = GetRandom.getRandomFrac();
        assertEquals(randomFrac, randomFrac1);
        int expectedHashCodeResult = randomFrac.hashCode();
        assertEquals(expectedHashCodeResult, randomFrac1.hashCode());
    }

    /**
     * Method under test: {@link Frac#equals(Object)}
     */
    @Test
    void testEquals4() {
        Frac frac = new Frac(2);
        assertNotEquals(frac, GetRandom.getRandomFrac());
    }

    /**
     * Method under test: {@link Frac#equals(Object)}
     */
    @Test
    void testEquals5() {
        Frac frac = new Frac(2);
        assertNotEquals(frac, new Frac(1, 10));
    }

    /**
     * Method under test: {@link Frac#getValue()}
     */
    @Test
    void testGetValue() {
        assertEquals(Double.NaN, GetRandom.getRandomFrac().getValue());
    }

    /**
     * Method under test: {@link Frac#toString()}
     */
    @Test
    void testToString() {
        assertEquals("0", GetRandom.getRandomFrac().toString());
        assertEquals("2", (new Frac(2)).toString());
        assertEquals("(10/-1)", (new Frac(-1, 10)).toString());
    }

    /**
     * Method under test: {@link Frac#isLegal()}
     */
    @Test
    void testIsLegal() {
        assertFalse(GetRandom.getRandomFrac().isLegal());
        assertFalse((new Frac(2)).isLegal());
        assertFalse((new Frac(0)).isLegal());
        assertFalse((new Frac(-1, 10)).isLegal());
        assertFalse((new Frac(-1, -1)).isLegal());
        assertTrue((new Frac(-1, 0)).isLegal());
    }

    /**
     * Method under test: {@link Frac#divide()}
     */
    @Test
    void testDivide() {
        Frac randomFrac = GetRandom.getRandomFrac();
        randomFrac.divide();
        assertEquals(0, randomFrac.numerator);
        assertEquals(0, randomFrac.denominator);
    }

    /**
     * Method under test: {@link Frac#divide()}
     */
    @Test
    void testDivide2() {
        Frac frac = new Frac(2);
        frac.divide();
        assertEquals(2, frac.numerator);
        assertEquals(1, frac.denominator);
    }

    /**
     * Method under test: {@link Frac#divide()}
     */
    @Test
    void testDivide3() {
        Frac frac = new Frac(1);
        frac.divide();
        assertEquals(1, frac.numerator);
        assertEquals(1, frac.denominator);
    }

    /**
     * Method under test: {@link Frac#divide()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDivide4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw


        (new Frac(Integer.MIN_VALUE)).divide();
    }

    /**
     * Method under test: {@link Frac#divide()}
     */
    @Test
    @Disabled
    void testDivide5() {
        Frac frac = new Frac(10, 0);
        Frac excepted = new Frac(1, 0);
        frac.divide();
        assertEquals(excepted, frac);
    }

    /**
     * Method under test: {@link Frac#divide()}
     */
    @Test
//    @Disabled("TODO: Complete this test")
    void testDivide6() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw



        Frac frac = new Frac(1, Integer.MIN_VALUE/99999);
        frac.divide();
    }

    /**
     * Method under test: {@link Frac#fracAdd(Frac)}
     */
    @Test
    void testFracAdd() {
        Frac randomFrac = GetRandom.getRandomFrac();
        Frac actualFracAddResult = randomFrac.fracAdd(GetRandom.getRandomFrac());
        assertEquals(0, actualFracAddResult.numerator);
        assertEquals(0, actualFracAddResult.denominator);
    }

    /**
     * Method under test: {@link Frac#fracAdd(Frac)}
     */
    @Test
    void testFracAdd2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot read field "denominator" because "frac" is null
        //       at ConstructedTools.Frac.fracAdd(Frac.java:64)
        //   See https://diff.blue/R013 to resolve this issue.

        boolean flag = false;
        try {
            GetRandom.getRandomFrac().fracAdd(null);
        }
        catch (Exception e)
        {
            flag=true;
        }
        assertTrue(flag);
    }

    /**
     * Method under test: {@link Frac#fracSub(Frac)}
     */
    @Test
    void testFracSub() {
        Frac randomFrac = GetRandom.getRandomFrac();
        Frac actualFracSubResult = randomFrac.fracSub(GetRandom.getRandomFrac());
        assertEquals(0, actualFracSubResult.numerator);
        assertEquals(0, actualFracSubResult.denominator);
    }

    /**
     * Method under test: {@link Frac#fracSub(Frac)}
     */
    @Test

    void testFracSub2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot read field "denominator" because "frac" is null
        //       at ConstructedTools.Frac.fracSub(Frac.java:73)
        //   See https://diff.blue/R013 to resolve this issue.
        boolean flag = false;
        try {
            GetRandom.getRandomFrac().fracSub(null);
        }
        catch (Exception e)
        {
            flag=true;
        }
        assertTrue(flag);

    }

    /**
     * Method under test: {@link Frac#fracMul(Frac)}
     */
    @Test
    void testFracMul() {
        Frac randomFrac = GetRandom.getRandomFrac();
        Frac actualFracMulResult = randomFrac.fracMul(GetRandom.getRandomFrac());
        assertEquals(0, actualFracMulResult.numerator);
        assertEquals(0, actualFracMulResult.denominator);
    }

    /**
     * Method under test: {@link Frac#fracMul(Frac)}
     */
    @Test

    void testFracMul2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot read field "denominator" because "frac" is null
        //       at ConstructedTools.Frac.fracMul(Frac.java:82)
        //   See https://diff.blue/R013 to resolve this issue.
        boolean flag = false;
        try {
            GetRandom.getRandomFrac().fracMul(null);
        }
        catch (Exception e)
        {
            flag=true;
        }
        assertTrue(flag);

    }

    /**
     * Method under test: {@link Frac#fracDiv(Frac)}
     */
    @Test
    void testFracDiv() throws RuntimeException {
        Frac randomFrac = GetRandom.getRandomFrac();
        assertThrows(RuntimeException.class, () -> randomFrac.fracDiv(GetRandom.getRandomFrac()));
    }

    /**
     * Method under test: {@link Frac#fracDiv(Frac)}
     */
    @Test
    void testFracDiv2() throws RuntimeException {
        Frac randomFrac = GetRandom.getRandomFrac();
        Frac actualFracDivResult = randomFrac.fracDiv(new Frac(2));
        assertEquals(0, actualFracDivResult.numerator);
        assertEquals(0, actualFracDivResult.denominator);
    }

    /**
     * Method under test: {@link Frac#fracDiv(Frac)}
     */
    @Test

    void testFracDiv3() throws RuntimeException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot read field "numerator" because "frac" is null
        //       at ConstructedTools.Frac.fracDiv(Frac.java:92)
        //   See https://diff.blue/R013 to resolve this issue.
        boolean flag = false;
        try {
            GetRandom.getRandomFrac().fracDiv(null);
        }
        catch (Exception e)
        {
            flag=true;
        }
        assertTrue(flag);

    }
}

