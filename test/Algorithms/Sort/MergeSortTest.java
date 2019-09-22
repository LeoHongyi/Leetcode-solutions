package Algorithms.Sort;

import org.junit.Test;

import static org.junit.Assert.*;

public class MergeSortTest {
    @Test
    public void testSelect1() {
        int[] i = new int[] {5,6,3,12,1,8,2};
        int[] e = new int[] {1,2,3,5,6,8,12};
        MergeSort sort = new MergeSort();
        sort.mergeSort(i);
        assertArrayEquals(e, i);
    }
    @Test
    public void testSelect2() {
        int[] i = new int[] {5,6,7,3,2,1};
        int[] e = new int[] {1,2,3,5,6,7};
        MergeSort sort = new MergeSort();
        sort.mergeSort(i);
        assertArrayEquals(e, i);
    }
    @Test
    public void testSelect3() {
        int[] i = new int[] {4, 2, 1, 1, 3, 2};
        int[] e = new int[] {1,1,2,2,3,4};
        MergeSort sort = new MergeSort();
        sort.mergeSort(i);
        assertArrayEquals(e, i);
    }
}