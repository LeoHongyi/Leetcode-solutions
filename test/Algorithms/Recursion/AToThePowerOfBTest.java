package Algorithms.Recursion;

import org.junit.Test;

import static org.junit.Assert.*;

public class AToThePowerOfBTest {
    @Test
    public void test1() {
        int a = 1;
        int b =  2147483647;
        AToThePowerOfB p = new AToThePowerOfB();
        long result = p.power(a, b);
        assertEquals (1, result);
    }
    @Test
    public void test2() {
        int a = 2;
        int b =  0;
        AToThePowerOfB p = new AToThePowerOfB();
        long result = p.power(a, b);
        assertEquals (1, result);
    }
    @Test
    public void test3() {
        int a = 0;
        int b =  2147483647;
        AToThePowerOfB p = new AToThePowerOfB();
        long result = p.power(a, b);
        assertEquals (0, result);
    }
    @Test
    public void test4() {
        int a = -2;
        int b =  5;
        AToThePowerOfB p = new AToThePowerOfB();
        long result = p.power(a, b);
        assertEquals (-32, result);
    }

}