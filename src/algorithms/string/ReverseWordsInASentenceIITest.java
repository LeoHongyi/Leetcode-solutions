package algorithms.string;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseWordsInASentenceIITest {
    ReverseWordsInASentenceII rw;
    @Before
    public void setUp() {
        rw = new ReverseWordsInASentenceII();
    }

    @Test
    public void test1() {
        String result = rw.reverseWords(" A B C D ");
        assertEquals("D C B A", result);
    }
    @Test
    public void test2() {
        String result = rw.reverseWords(" I  love  Google  ");
        assertEquals("Google love I", result);
    }
}