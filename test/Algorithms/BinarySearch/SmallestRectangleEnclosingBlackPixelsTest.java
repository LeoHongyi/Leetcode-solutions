package Algorithms.BinarySearch;

import org.junit.Test;

import static org.junit.Assert.*;

public class SmallestRectangleEnclosingBlackPixelsTest {
    @Test
    public void test1() {
        int[][] image = new int[][]{{0,1,0},{0,1,0},{0,0,0},{1,1,0},{0,0,0},{1,1,1}};
        int a = 0;
        int b = 1;
        SmallestRectangleEnclosingBlackPixels sr = new SmallestRectangleEnclosingBlackPixels();
        int result = sr.minArea(image, a, b);
        assertEquals(18, result);
    }

}