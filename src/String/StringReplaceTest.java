package String;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringReplaceTest {
    StringReplace sr;

    @Before
    public void setUp() throws Exception {
        sr = new StringReplace();
    }

    @Test
    public void test1() {
        String result = sr.replace("appledogapple","apple","cat");
        assertEquals("catdogcat", result);
    }
    @Test
    public void test2() {
        String result = sr.replace("dodododo","dod","a");
        assertEquals("aoao", result);
    }
}