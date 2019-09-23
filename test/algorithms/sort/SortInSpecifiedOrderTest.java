package algorithms.sort;

import org.junit.Test;

import static org.junit.Assert.*;

public class SortInSpecifiedOrderTest {
    @Test
    public void test1() {
        int[] a1 = new int[] {2, 1, 2, 5, 7, 1, 9, 3};
        int[] a2 = new int[] {2, 1, 3};
        int[] e = new int[] {2, 2, 1, 1, 3, 5, 7, 9};
        SortInSpecifiedOrder sort = new SortInSpecifiedOrder();
        a1 = sort.sortSpecial(a1, a2);
        assertArrayEquals(e, a1);
    }

    @Test
    public void test2() {
        int[] a1 = new int[] {4,4,3,3,3};
        int[] a2 = new int[] {4};
        int[] e = new int[] {4,4,3,3,3};
        SortInSpecifiedOrder sort = new SortInSpecifiedOrder();
        a1 = sort.sortSpecial(a1, a2);
        assertArrayEquals(e, a1);
    }
    @Test
    public void test3() {
        int[] a1 = new int[] {2, 1, 2, 5, 7, 1, 9, 3};
        int[] a2 = new int[] {2, 1};
        int[] e = new int[] {2, 2, 1, 1, 3,5,7,9};
        SortInSpecifiedOrder sort = new SortInSpecifiedOrder();
        a1 = sort.sortSpecial(a1, a2);
        assertArrayEquals(e, a1);
    }
    @Test
    public void test4() {
        int[] a1 = new int[] {5,4,9,7};
        int[] a2 = new int[] {3,1,2};
        int[] e = new int[] {4, 5, 7, 9};
        SortInSpecifiedOrder sort = new SortInSpecifiedOrder();
        a1 = sort.sortSpecial(a1, a2);
        assertArrayEquals(e, a1);
    }
    @Test
    public void test5() {
        int[] a1 = new int[] {4,2,1,3};
        int[] a2 = new int[] {};
        int[] e = new int[] {1,2,3,4};
        SortInSpecifiedOrder sort = new SortInSpecifiedOrder();
        a1 = sort.sortSpecial(a1, a2);
        assertArrayEquals(e, a1);
    }
    @Test
    public void test6() {
        int[] a1 = new int[] {4,4,1,1};
        int[] a2 = new int[] {4,2,1,3};
        int[] e = new int[] {4,4,1,1};
        SortInSpecifiedOrder sort = new SortInSpecifiedOrder();
        a1 = sort.sortSpecial(a1, a2);
        assertArrayEquals(e, a1);
    }
}