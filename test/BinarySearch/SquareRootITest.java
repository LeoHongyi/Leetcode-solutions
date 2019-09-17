package BinarySearch;

import org.junit.Test;

import static org.junit.Assert.*;

public class SquareRootITest {
    @Test
    public void test1() {
        int input = 2147395600;
        SquareRootI sr = new SquareRootI();
        int result = sr.sqrt(input);
        assertEquals(46340, result);
    }

    @Test
    public void test2() {
        int input = 99;
        SquareRootI sr = new SquareRootI();
        int result = sr.sqrt(input);
        assertEquals(9, result);
    }

    @Test
    public void test3() {
        int input = 2;
        SquareRootI sr = new SquareRootI();
        int result = sr.sqrt(input);
        assertEquals(1, result);
    }

    @Test
    public void test4() {
        int input = 1;
        SquareRootI sr = new SquareRootI();
        int result = sr.sqrt(input);
        assertEquals(1, result);
    }

    @Test
    public void test5() {
        int input = 100000;
        SquareRootI sr = new SquareRootI();
        int result = sr.sqrt(input);
        assertEquals(316, result);
    }
}