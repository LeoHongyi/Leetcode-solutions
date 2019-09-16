package BinarySearch;

import org.junit.Test;

import static org.junit.Assert.*;

public class SearchInShiftedSortedArrayITest {
    @Test
    public void test1() {
        int[] input = new int[] {20,30,2,12,13,14,15};
        int target = 30;
        SearchInShiftedSortedArrayI s = new SearchInShiftedSortedArrayI();
        int result = s.search(input, target);
        assertEquals(1, result);
    }
}