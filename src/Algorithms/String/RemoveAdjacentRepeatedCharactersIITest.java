package Algorithms.String;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RemoveAdjacentRepeatedCharactersIITest {
    RemoveAdjacentRepeatedCharactersII dedup;
    @Before
    public void setUp() {
        dedup = new RemoveAdjacentRepeatedCharactersII();
    }

    @Test
    public void test1() {
        String result = dedup.deDuplicate("aabbbbbcccccdddd");
        assertEquals("aabbccdd", result);
    }
    @Test
    public void test2() {
        String result = dedup.deDuplicate("aaaabbbc");
        assertEquals("aabbc", result);
    }
}
