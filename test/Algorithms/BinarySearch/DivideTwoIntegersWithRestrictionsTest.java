package Algorithms.BinarySearch;

import org.junit.Test;

import static org.junit.Assert.*;

public class DivideTwoIntegersWithRestrictionsTest {
    @Test
    public void test1() {
        int a = -51;
        int b = 51;
        DivideTwoIntegersWithRestrictions dt = new DivideTwoIntegersWithRestrictions();
        int result = dt.divide(a, b);
        assertEquals(-1, result);
    }
    @Test
    public void test2() {
        int a = -11;
        int b = 2;
        DivideTwoIntegersWithRestrictions dt = new DivideTwoIntegersWithRestrictions();
        int result = dt.divide(a, b);
        assertEquals(-5, result);
    }
    @Test
    public void test3() {
        int a = 0;
        int b = 1;
        DivideTwoIntegersWithRestrictions dt = new DivideTwoIntegersWithRestrictions();
        int result = dt.divide(a, b);
        assertEquals(0, result);
    }
    @Test
    public void test4() {
        int a = 1;
        int b = 0;
        DivideTwoIntegersWithRestrictions dt = new DivideTwoIntegersWithRestrictions();
        int result = dt.divide(a, b);
        assertEquals(Integer.MAX_VALUE, result);
    }
    @Test
    public void test5() {
        int a = -1;
        int b = 0;
        DivideTwoIntegersWithRestrictions dt = new DivideTwoIntegersWithRestrictions();
        int result = dt.divide(a, b);
        assertEquals(Integer.MAX_VALUE, result);
    }
    @Test
    public void test6() {
        int a = 11;
        int b = 2;
        DivideTwoIntegersWithRestrictions dt = new DivideTwoIntegersWithRestrictions();
        int result = dt.divide(a, b);
        assertEquals(5, result);
    }
    @Test
    public void test7() {
        int a = -11;
        int b = 2;
        DivideTwoIntegersWithRestrictions dt = new DivideTwoIntegersWithRestrictions();
        int result = dt.divide(a, b);
        assertEquals(-5, result);
    }
    @Test
    public void test8() {
        int a = -2147483648;
        int b = -1;
        DivideTwoIntegersWithRestrictions dt = new DivideTwoIntegersWithRestrictions();
        int result = dt.divide(a, b);
        assertEquals(2147483647, result);
    }

}