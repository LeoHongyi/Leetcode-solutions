package DP;

import org.junit.Test;

import static org.junit.Assert.*;

public class FibonacciTest {
    @Test
    public void test1() {
        int input = 5;
        Fibonacci f = new Fibonacci();
        int result = f.fibonacciRecursion(input);
        assertEquals(5, result);
    }
    @Test
    public void test2() {
        int input = 16;
        Fibonacci f = new Fibonacci();
        int result = f.fibonacciRecursion(input);
        assertEquals(987, result);
    }
    @Test
    public void test3() {
        int input = 17;
        Fibonacci f = new Fibonacci();
        int result = f.fibonacciRecursion(input);
        assertEquals(1597, result);
    }

}