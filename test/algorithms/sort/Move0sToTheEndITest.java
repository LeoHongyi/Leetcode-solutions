package algorithms.sort;

import org.junit.Test;

import static org.junit.Assert.*;

public class Move0sToTheEndITest {

    @Test
    public void testSelect1() {
        int[] i = new int[] {0,0,1,1,0,1,0};
        int[] e = new int[] {1,1,1,0,0,0,0};
        Move0sToTheEndI sort = new Move0sToTheEndI();
        sort.moveZero(i);
        assertArrayEquals(e, i);
    }
    @Test
    public void testSelect2() {
        int[] i = new int[] {1};
        int[] e = new int[] {1};
        Move0sToTheEndI sort = new Move0sToTheEndI();
        sort.moveZero(i);
        assertArrayEquals(e, i);
    }
    @Test
    public void testSelect3() {
        int[] i = new int[] {1, 0, 3, 0, 1};
        int[] e = new int[] {1,1,3,0,0};
        Move0sToTheEndI sort = new Move0sToTheEndI();
        sort.moveZero(i);
        assertArrayEquals(e, i);
    }

}