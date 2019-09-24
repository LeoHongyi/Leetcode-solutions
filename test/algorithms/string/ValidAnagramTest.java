package algorithms.string;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidAnagramTest {
    ValidAnagram va;
    @Before
    public void setUp() {
        va = new ValidAnagram();
    }

    @Test
    public void isAnagram() {
        boolean result = va.isAnagram("anagram", "nagaram");
        assertTrue(result);
    }
}