package Algorithms.String;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidPalindromeIITest {
    ValidPalindromeII vpII;
    @Before
    public void setUp() {
        vpII = new ValidPalindromeII();
    }

    @Test
    public void test1() {
        boolean result = vpII.validPalindrome("yvzohgsseqhgexvbqzojjgfyzhchtzyycsputijtxuzygfytzhaahztyfgyzuxtjitupscyyzthhzyfgjjoznqbvxeghqessghozvy");
        assertFalse(result);
    }
    @Test
    public void test2() {
        boolean result = vpII.validPalindrome("abaca");
        assertFalse(result);
    }
    @Test
    public void test3() {
        boolean result = vpII.validPalindrome("aba");
        assertTrue(result);
    }
    @Test
    public void test4() {
        boolean result = vpII.validPalindrome("abca");
        assertTrue(result);
    }
    @Test
    public void test5() {
        boolean result = vpII.validPalindrome("abac");
        assertTrue(result);
    }
}