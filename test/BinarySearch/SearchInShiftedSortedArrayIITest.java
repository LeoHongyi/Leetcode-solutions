package BinarySearch;

import org.junit.Test;

import static org.junit.Assert.*;

public class SearchInShiftedSortedArrayIITest {
    @Test
    public void test1() {
        int[] input = new int[] {3, 4, 5, 1, 2};
        int target = 4;
        SearchInShiftedSortedArrayII s = new SearchInShiftedSortedArrayII();
        int result = s.search(input, target);
        assertEquals(1, result);
    }

    @Test
    public void test2() {
        int[] input = new int[] {3, 3, 3, 1, 3};
        int target = 1;
        SearchInShiftedSortedArrayII s = new SearchInShiftedSortedArrayII();
        int result = s.search(input, target);
        assertEquals(3, result);
    }

    @Test
    public void test3() {
        int[] input = new int[] {3, 1, 3, 3, 3};
        int target = 1;
        SearchInShiftedSortedArrayII s = new SearchInShiftedSortedArrayII();
        int result = s.search(input, target);
        assertEquals(1, result);
    }
}