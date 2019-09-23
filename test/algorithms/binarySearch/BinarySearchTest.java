package algorithms.binarySearch;
import static org.junit.Assert.*;
import org.junit.Test;

public class BinarySearchTest {
    @Test
    public void test() {
        BinarySearch  bs = new BinarySearch();
        int[] input = new int[] {1,2,3,4,5,6,7,8};
        int result = bs.binarySearch(input, 2);
        assertEquals(1, result);
    }
}