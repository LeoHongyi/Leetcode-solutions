package algorithms.hashTable;

import algorithms.heap.KClosestPointsToOrigin;
import org.junit.Test;

import static org.junit.Assert.*;

public class KClosestPointsToOriginTest {
    @Test
    public void kClosest2DTest1() {
        int[][] input = new int[][] {{3,3},{5,-1}, {-2,4}};
        int k = 2;
        int[][] exp = new int[][] {{-2, 4}, {3,3}};
        KClosestPointsToOrigin c = new KClosestPointsToOrigin();
        int[][] result = c.kClosest(input, k);
        for (int i = 0; i < result.length; i++) {
            assertArrayEquals(exp[i], result[i]);
        }
    }
    @Test
    public void kClosest2DTest2() {
        int[][] input = new int[][] {{1,3},{-2,2}};
        int k = 1;
        int[][] exp = new int[][] {{-2, 2}};
        KClosestPointsToOrigin c = new KClosestPointsToOrigin();
        int[][] result = c.kClosest(input, k);
        for (int i = 0; i < result.length; i++) {
            assertArrayEquals(exp[i], result[i]);
        }
    }
}