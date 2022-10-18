package ConstructedTools;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class CalStrTest {
    /**
     * Method under test: {@link CalStr#cal(List)}
     */
    @Test
//    @Disabled("TODO: Complete this test")
    void testCal() throws Exception {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.util.EmptyStackException
        //       at java.util.Stack.peek(Stack.java:101)
        //       at ConstructedTools.CalStr.cal(CalStr.java:47)
        //   See https://diff.blue/R013 to resolve this issue.
        boolean flag = false;
        try {
            CalStr.cal(new ArrayList<>());
        } catch (Exception e) {
            flag = true;
        }
        assertTrue(flag);
    }

    /**
     * Method under test: {@link CalStr#cal(List)}
     */
    @Test
//    @Disabled("TODO: Complete this test")
    void testCal2() throws Exception {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.util.EmptyStackException
        //       at java.util.Stack.peek(Stack.java:101)
        //       at java.util.Stack.pop(Stack.java:83)
        //       at ConstructedTools.CalStr.cal(CalStr.java:22)
        //   See https://diff.blue/R013 to resolve this issue.
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("foo");
        boolean flag = false;
        try {
            CalStr.cal(stringList);
        }catch (Exception e){
            flag = true;
        }
        assertTrue(flag);
    }

    /**
     * Method under test: {@link CalStr#cal(List)}
     */
    @Test
//    @Disabled("TODO: Complete this test")
    void testCal3() throws Exception {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.util.EmptyStackException
        //       at java.util.Stack.peek(Stack.java:101)
        //       at java.util.Stack.pop(Stack.java:83)
        //       at ConstructedTools.CalStr.cal(CalStr.java:23)
        //   See https://diff.blue/R013 to resolve this issue.

        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("9");
        stringList.add("foo");boolean flag = false;
        try {
            CalStr.cal(stringList);
        }catch (Exception e){
            flag = true;
        }
        assertTrue(flag);
    }

    /**
     * Method under test: {@link CalStr#cal(List)}
     */
    @Test
    void testCal4() throws Exception {
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("9");
        Frac actualCalResult = CalStr.cal(stringList);
        assertEquals(9, actualCalResult.numerator);
        assertEquals(1, actualCalResult.denominator);
    }

    /**
     * Method under test: {@link CalStr#cal(List)}
     */
    @Test
    void testCal5() throws Exception {
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("42");
        Frac actualCalResult = CalStr.cal(stringList);
        assertEquals(42, actualCalResult.numerator);
        assertEquals(1, actualCalResult.denominator);
    }

    /**
     * Method under test: {@link CalStr#cal(List)}
     */
    @Test
    void testCal6() throws Exception {
        boolean flag = false;
        try {
            ArrayList<String> stringList = new ArrayList<>();
            stringList.add("9");
            stringList.add("9");
            stringList.add("foo");
            Frac actualCalResult = CalStr.cal(stringList);

        } catch (Exception e)
        {
            flag=true;
        }
        assertTrue(flag);
    }

    /**
     * Method under test: {@link CalStr#expressionToList(String)}
     */
    @Test
    void testExpressionToList() {
        List<String> actualExpressionToListResult = CalStr.expressionToList("Expression");
        assertEquals(10, actualExpressionToListResult.size());
        assertEquals("E", actualExpressionToListResult.get(0));
        assertEquals("x", actualExpressionToListResult.get(1));
        assertEquals("p", actualExpressionToListResult.get(2));
        assertEquals("r", actualExpressionToListResult.get(3));
        assertEquals("e", actualExpressionToListResult.get(4));
        assertEquals("s", actualExpressionToListResult.get(5));
        assertEquals("s", actualExpressionToListResult.get(6));
        assertEquals("i", actualExpressionToListResult.get(7));
        assertEquals("o", actualExpressionToListResult.get(8));
        assertEquals("n", actualExpressionToListResult.get(9));
    }

    /**
     * Method under test: {@link CalStr#expressionToList(String)}
     */
    @Test
//    @Disabled("TODO: Complete this test")
    void testExpressionToList2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.StringIndexOutOfBoundsException: String index out of range: 0
        //       at java.lang.StringLatin1.charAt(StringLatin1.java:48)
        //       at java.lang.String.charAt(String.java:1515)
        //       at ConstructedTools.CalStr.expressionToList(CalStr.java:59)
        //   See https://diff.blue/R013 to resolve this issue.

        CalStr.expressionToList("");
    }

    /**
     * Method under test: {@link CalStr#expressionToList(String)}
     */
    @Test
    void testExpressionToList3() {
        List<String> actualExpressionToListResult = CalStr.expressionToList("42");
        assertEquals(1, actualExpressionToListResult.size());
        assertEquals("42", actualExpressionToListResult.get(0));
    }

    /**
     * Method under test: {@link CalStr#expressionToList(String)}
     */
    @Test
    void testExpressionToList4() {
        List<String> actualExpressionToListResult = CalStr.expressionToList("(");
        assertEquals(1, actualExpressionToListResult.size());
        assertEquals("(", actualExpressionToListResult.get(0));
    }

    /**
     * Method under test: {@link CalStr#expressionToList(String)}
     */
    @Test
    void testExpressionToList5() {
        List<String> actualExpressionToListResult = CalStr.expressionToList("42Expression");
        assertEquals(11, actualExpressionToListResult.size());
        assertEquals("42", actualExpressionToListResult.get(0));
        assertEquals("E", actualExpressionToListResult.get(1));
        assertEquals("x", actualExpressionToListResult.get(2));
        assertEquals("p", actualExpressionToListResult.get(3));
        assertEquals("r", actualExpressionToListResult.get(4));
        assertEquals("e", actualExpressionToListResult.get(5));
        assertEquals("s", actualExpressionToListResult.get(6));
        assertEquals("s", actualExpressionToListResult.get(7));
        assertEquals("i", actualExpressionToListResult.get(8));
        assertEquals("o", actualExpressionToListResult.get(9));
        assertEquals("n", actualExpressionToListResult.get(10));
    }

    /**
     * Method under test: {@link CalStr#expressionToList(String)}
     */
    @Test
    void testExpressionToList6() {
        List<String> actualExpressionToListResult = CalStr.expressionToList("42(");
        assertEquals(2, actualExpressionToListResult.size());
        assertEquals("42", actualExpressionToListResult.get(0));
        assertEquals("(", actualExpressionToListResult.get(1));
    }

    /**
     * Method under test: {@link CalStr#parseToSuffixExpression(List)}
     */
    @Test
    void testParseToSuffixExpression() {
        assertTrue(CalStr.parseToSuffixExpression(new ArrayList<>()).isEmpty());
    }

    /**
     * Method under test: {@link CalStr#parseToSuffixExpression(List)}
     */
    @Test
    void testParseToSuffixExpression2() {
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("foo");
        assertThrows(RuntimeException.class, () -> CalStr.parseToSuffixExpression(stringList));
    }

    /**
     * Method under test: {@link CalStr#parseToSuffixExpression(List)}
     */
    @Test
    void testParseToSuffixExpression3() {
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("9");
        stringList.add("foo");
        assertThrows(RuntimeException.class, () -> CalStr.parseToSuffixExpression(stringList));
    }

    /**
     * Method under test: {@link CalStr#parseToSuffixExpression(List)}
     */
    @Test
    void testParseToSuffixExpression4() {
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("+");
        List<String> actualParseToSuffixExpressionResult = CalStr.parseToSuffixExpression(stringList);
        assertEquals(1, actualParseToSuffixExpressionResult.size());
        assertEquals("+", actualParseToSuffixExpressionResult.get(0));
    }

    /**
     * Method under test: {@link CalStr#parseToSuffixExpression(List)}
     */
    @Test
    void testParseToSuffixExpression5() {
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("-");
        List<String> actualParseToSuffixExpressionResult = CalStr.parseToSuffixExpression(stringList);
        assertEquals(1, actualParseToSuffixExpressionResult.size());
        assertEquals("-", actualParseToSuffixExpressionResult.get(0));
    }

    /**
     * Method under test: {@link CalStr#parseToSuffixExpression(List)}
     */
    @Test
    void testParseToSuffixExpression6() {
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("*");
        List<String> actualParseToSuffixExpressionResult = CalStr.parseToSuffixExpression(stringList);
        assertEquals(1, actualParseToSuffixExpressionResult.size());
        assertEquals("*", actualParseToSuffixExpressionResult.get(0));
    }

    /**
     * Method under test: {@link CalStr#parseToSuffixExpression(List)}
     */
    @Test
    void testParseToSuffixExpression7() {
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("/");
        List<String> actualParseToSuffixExpressionResult = CalStr.parseToSuffixExpression(stringList);
        assertEquals(1, actualParseToSuffixExpressionResult.size());
        assertEquals("/", actualParseToSuffixExpressionResult.get(0));
    }

    /**
     * Method under test: {@link CalStr#parseToSuffixExpression(List)}
     */
    @Test
    void testParseToSuffixExpression8() {
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("42");
        List<String> actualParseToSuffixExpressionResult = CalStr.parseToSuffixExpression(stringList);
        assertEquals(1, actualParseToSuffixExpressionResult.size());
        assertEquals("42", actualParseToSuffixExpressionResult.get(0));
    }

    /**
     * Method under test: {@link CalStr#parseToSuffixExpression(List)}
     */
    @Test
    void testParseToSuffixExpression9() {
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("(");
        List<String> actualParseToSuffixExpressionResult = CalStr.parseToSuffixExpression(stringList);
        assertEquals(1, actualParseToSuffixExpressionResult.size());
        assertEquals("(", actualParseToSuffixExpressionResult.get(0));
    }

    /**
     * Method under test: {@link CalStr#parseToSuffixExpression(List)}
     */
    @Test
    void testParseToSuffixExpression10() {
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add(")");
        assertTrue(CalStr.parseToSuffixExpression(stringList).isEmpty());
    }

    /**
     * Method under test: {@link CalStr#parseToSuffixExpression(List)}
     */
    @Test
    void testParseToSuffixExpression11() {
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("+");
        stringList.add("+");
        List<String> actualParseToSuffixExpressionResult = CalStr.parseToSuffixExpression(stringList);
        assertEquals(2, actualParseToSuffixExpressionResult.size());
        assertEquals("+", actualParseToSuffixExpressionResult.get(0));
        assertEquals("+", actualParseToSuffixExpressionResult.get(1));
    }

    /**
     * Method under test: {@link CalStr#parseToSuffixExpression(List)}
     */
    @Test
    void testParseToSuffixExpression12() {
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("(");
        stringList.add("+");
        List<String> actualParseToSuffixExpressionResult = CalStr.parseToSuffixExpression(stringList);
        assertEquals(2, actualParseToSuffixExpressionResult.size());
        assertEquals("+", actualParseToSuffixExpressionResult.get(0));
        assertEquals("(", actualParseToSuffixExpressionResult.get(1));
    }

    /**
     * Method under test: {@link CalStr#parseToSuffixExpression(List)}
     */
    @Test
    void testParseToSuffixExpression13() {
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("*");
        stringList.add("+");
        List<String> actualParseToSuffixExpressionResult = CalStr.parseToSuffixExpression(stringList);
        assertEquals(2, actualParseToSuffixExpressionResult.size());
        assertEquals("*", actualParseToSuffixExpressionResult.get(0));
        assertEquals("+", actualParseToSuffixExpressionResult.get(1));
    }

    /**
     * Method under test: {@link CalStr#parseToSuffixExpression(List)}
     */
    @Test
    void testParseToSuffixExpression14() {
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("/");
        stringList.add("+");
        List<String> actualParseToSuffixExpressionResult = CalStr.parseToSuffixExpression(stringList);
        assertEquals(2, actualParseToSuffixExpressionResult.size());
        assertEquals("/", actualParseToSuffixExpressionResult.get(0));
        assertEquals("+", actualParseToSuffixExpressionResult.get(1));
    }

    /**
     * Method under test: {@link CalStr#parseToSuffixExpression(List)}
     */
    @Test
    void testParseToSuffixExpression15() {
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("+");
        stringList.add("-");
        List<String> actualParseToSuffixExpressionResult = CalStr.parseToSuffixExpression(stringList);
        assertEquals(2, actualParseToSuffixExpressionResult.size());
        assertEquals("+", actualParseToSuffixExpressionResult.get(0));
        assertEquals("-", actualParseToSuffixExpressionResult.get(1));
    }

    /**
     * Method under test: {@link CalStr#parseToSuffixExpression(List)}
     */
    @Test
    void testParseToSuffixExpression16() {
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("+");
        stringList.add("*");
        List<String> actualParseToSuffixExpressionResult = CalStr.parseToSuffixExpression(stringList);
        assertEquals(2, actualParseToSuffixExpressionResult.size());
        assertEquals("*", actualParseToSuffixExpressionResult.get(0));
        assertEquals("+", actualParseToSuffixExpressionResult.get(1));
    }

    /**
     * Method under test: {@link CalStr#isOperator(String)}
     */
    @Test
    void testIsOperator() {
        assertFalse(CalStr.isOperator("Op"));
        assertTrue(CalStr.isOperator((String) "+"));
        assertTrue(CalStr.isOperator((String) "-"));
        assertTrue(CalStr.isOperator((String) "*"));
        assertTrue(CalStr.isOperator((String) "/"));
    }

    /**
     * Method under test: {@link CalStr#isNumber(String)}
     */
    @Test
    void testIsNumber() {
        assertFalse(CalStr.isNumber("Num"));
        assertTrue(CalStr.isNumber("9"));
        assertTrue(CalStr.isNumber("42"));
        assertTrue(CalStr.isNumber("99"));
        assertTrue(CalStr.isNumber("942"));
        assertTrue(CalStr.isNumber("4242"));
        assertTrue(CalStr.isNumber("429"));
        assertTrue(CalStr.isNumber("999"));
        assertTrue(CalStr.isNumber("9942"));
        assertTrue(CalStr.isNumber("9429"));
        assertTrue(CalStr.isNumber("94242"));
    }

    /**
     * Method under test: {@link CalStr#priority(String)}
     */
    @Test
    void testPriority() {
        assertEquals(-1, CalStr.priority("Op"));
        assertEquals(1, CalStr.priority((String) "*"));
        assertEquals(1, CalStr.priority((String) "/"));
        assertEquals(0, CalStr.priority((String) "+"));
        assertEquals(0, CalStr.priority((String) "-"));
    }
}

