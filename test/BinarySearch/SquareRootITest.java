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
}