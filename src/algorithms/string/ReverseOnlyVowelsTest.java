package algorithms.string;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseOnlyVowelsTest {
    ReverseOnlyVowels rov;

    @Before
    public void setUp() throws Exception {
        rov = new ReverseOnlyVowels();
    }
    @Test
    public void test1() {
        String result = rov.reverse("chkzdlprg");
        assertEquals("chkzdlprg", result);
    }
    @Test
    public void test2() {
        String result = rov.reverse("abbegi");
        assertEquals("ibbega", result);
    }
}