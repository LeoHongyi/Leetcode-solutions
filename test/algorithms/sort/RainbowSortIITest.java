package algorithms.sort;

import org.junit.Test;

import static org.junit.Assert.*;

public class RainbowSortIITest {

    @Test
    public void test1rainbowSortII() {
        int[] a = new int[] {1,3,0,2,0,0,1};
        int[] e = new int[] {0, 0, 0, 1, 1, 2, 3};
        RainbowSortII sort = new RainbowSortII();
        a = sort.rainbowSortII(a);
        assertArrayEquals(e, a);
    }
    @Test
    public void test2rainbowSortII() {
        int[] a = new int[] {1, 3, 1, 2, 0};
        int[] e = new int[] {0, 1, 1, 2, 3};
        RainbowSortII sort = new RainbowSortII();
        a = sort.rainbowSortII(a);
        assertArrayEquals(e, a);
    }
    @Test
    public void test3rainbowSortII() {
        int[] a = new int[] {1,0};
        int[] e = new int[] {0,1};
        RainbowSortII sort = new RainbowSortII();
        a = sort.rainbowSortII(a);
        assertArrayEquals(e, a);
    }
    @Test
    public void test4rainbowSortII() {
        int[] a = new int[] {2,1,3,0,2,1,2,0,3};
        int[] e = new int[] {0,0,1,1,2,2,2,3,3};
        RainbowSortII sort = new RainbowSortII();
        a = sort.rainbowSortII(a);
        assertArrayEquals(e, a);
    }
    @Test
    public void test5rainbowSortII() {
        int[] a = new int[] {0};
        int[] e = new int[] {0};
        RainbowSortII sort = new RainbowSortII();
        a = sort.rainbowSortII(a);
        assertArrayEquals(e, a);
    }
}