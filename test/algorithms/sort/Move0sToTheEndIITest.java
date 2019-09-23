package algorithms.sort;

import org.junit.Test;

import static org.junit.Assert.*;

public class Move0sToTheEndIITest {
    @Test
    public void test1() {
        int[] a = {1, 0, 3, 0, 1};
        int[] e = {1, 3, 1, 0, 0};
        Move0sToTheEndII sort = new Move0sToTheEndII();
        a = sort.moveZero(a);
        assertArrayEquals(e, a);
    }
    @Test
    public void test2() {
        int[] a = {0,0,4,-7,0,8,0};
        int[] e = {4, -7, 8, 0, 0, 0, 0};
        Move0sToTheEndII sort = new Move0sToTheEndII();
        a = sort.moveZero(a);
        assertArrayEquals(e, a);
    }
    @Test
    public void test3() {
        int[] a = {1,2,3};
        int[] e = {1,2,3};
        Move0sToTheEndII sort = new Move0sToTheEndII();
        a = sort.moveZero(a);
        assertArrayEquals(e, a);
    }

}