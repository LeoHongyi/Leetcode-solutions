package String;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveAdjacentRepeatedCharactersIIITest {
    RemoveAdjacentRepeatedCharactersIII dedup;
    @Before
    public void setUp() throws Exception {
        dedup = new RemoveAdjacentRepeatedCharactersIII();
    }

    @Test
    public void test1() {
        String result = dedup.deDup("aabbbbbcccccdddd");
        assertEquals("", result);
    }
    @Test
    public void test2() {
        String result = dedup.deDup("aaaabbbc");
        assertEquals("c", result);
    }
    @Test
    public void test3() {
        String result = dedup.deDup("abbccde");
        assertEquals("ade", result);
    }
}


