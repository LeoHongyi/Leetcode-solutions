package Algorithms.BinarySearch;

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

    @Test
    public void test2() {
        int[] input = new int[] {15,1,3,6,10};
        int target = 10;
        SearchInShiftedSortedArrayI s = new SearchInShiftedSortedArrayI();
        int result = s.search(input, target);
        assertEquals(4, result);
    }

    @Test
    public void test3() {
        int[] input = new int[] {3,4,5,1,2};
        int target = 4;
        SearchInShiftedSortedArrayI s = new SearchInShiftedSortedArrayI();
        int result = s.search(input, target);
        assertEquals(1, result);
    }

    @Test
    public void test4() {
        int[] input = new int[] {1, 2, 3, 4, 5};
        int target = 4;
        SearchInShiftedSortedArrayI s = new SearchInShiftedSortedArrayI();
        int result = s.search(input, target);
        assertEquals(3, result);
    }

    @Test
    public void test5() {
        int[] input = new int[] {3, 5, 6, 1, 2};
        int target = 4;
        SearchInShiftedSortedArrayI s = new SearchInShiftedSortedArrayI();
        int result = s.search(input, target);
        assertEquals(-1, result);
    }
    @Test
    public void test6() {
        int[] input = new int[] {2,1};
        int target = 1;
        SearchInShiftedSortedArrayI s = new SearchInShiftedSortedArrayI();
        int result = s.search(input, target);
        assertEquals(1, result);
    }
}