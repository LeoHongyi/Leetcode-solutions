package algorithms.dynamicProgramming;

import org.junit.Test;

import static org.junit.Assert.*;

public class FibonacciTest {
    @Test
    public void test1() {
        int input = 5;
        FibonacciNumber f = new FibonacciNumber();
        int result = f.fibonacciRecursion(input);
        assertEquals(5, result);
    }
    @Test
    public void test2() {
        int input = 16;
        FibonacciNumber f = new FibonacciNumber();
        int result = f.fibonacciRecursion(input);
        assertEquals(987, result);
    }
    @Test
    public void test3() {
        int input = 17;
        FibonacciNumber f = new FibonacciNumber();
        int result = f.fibonacciRecursion(input);
        assertEquals(1597, result);
    }

}