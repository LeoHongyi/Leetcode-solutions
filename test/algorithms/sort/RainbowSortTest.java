package algorithms.sort;

import org.junit.Test;

import static org.junit.Assert.*;

public class RainbowSortTest {
    @Test
    public void testSelect1() {
        int[] i = new int[] {-1,1,1,-1,0,1,0,-1,0};
        int[] e = new int[] {-1,-1,-1,0,0,0,1,1,1};
        RainbowSort sort = new RainbowSort();
        sort.rainbowSort(i);
        assertArrayEquals(e, i);
    }
    @Test
    public void testSelect2() {
        int[] i = new int[] {1};
        int[] e = new int[] {1};
        RainbowSort sort = new RainbowSort();
        sort.rainbowSort(i);
        assertArrayEquals(e, i);
    }
    @Test
    public void testSelect3() {
        int[] i = new int[] {-1,-1,0,1,1,1,0,-1,0};
        int[] e = new int[] {-1,-1,-1,0,0,0,1,1,1};
        RainbowSort sort = new RainbowSort();
        sort.rainbowSort(i);
        assertArrayEquals(e, i);
    }
}