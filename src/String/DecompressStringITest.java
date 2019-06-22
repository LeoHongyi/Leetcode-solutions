package String;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DecompressStringITest {
    DecompressStringI dc;
    @Before
    public void setUp() throws Exception {
        dc = new DecompressStringI();
    }

    @Test
    public void test1() {
        String result = dc.decompress("ap2lec3n");
        assertEquals("applecccn", result);

    }
    @Test
    public void test2() {
        String result = dc.decompress("ap2l4e2c3n2");
        assertEquals("applllleecccnn", result);

    }
}
