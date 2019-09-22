package Algorithms.BinarySearch;

import org.junit.Test;

import static org.junit.Assert.*;

public class IntersectionOfTwoArraysIITest {
    @Test
    public void test1() {
        int[] a = new int[] {2,1};
        int[] b = new int[] {1,1};
        int[] expect = new int[] {1};
        IntersectionOfTwoArraysII i = new IntersectionOfTwoArraysII();
        int[] result = i.intersect(a,b);
        assertArrayEquals(expect, result);
    }
    @Test
    public void test2() {
        int[] a = new int[] {1,2,2,1};
        int[] b = new int[] {2,2};
        int[] expect = new int[] {2, 2};
        IntersectionOfTwoArraysII i = new IntersectionOfTwoArraysII();
        int[] result = i.intersect(a,b);
        assertArrayEquals(expect, result);
    }
    @Test
    public void test3() {
        int[] a = new int[] {4,9,5};
        int[] b = new int[] {4,4,8,9,9};
        int[] expect = new int[] {4,9};
        IntersectionOfTwoArraysII i = new IntersectionOfTwoArraysII();
        int[] result = i.intersect(a,b);
        assertArrayEquals(expect, result);
    }
    @Test
    public void test4() {
        int[] a = new int[] {4,4,9,9,5};
        int[] b = new int[] {4,4,8,9,9};
        int[] expect = new int[] {4,4,9,9};
        IntersectionOfTwoArraysII i = new IntersectionOfTwoArraysII();
        int[] result = i.intersect(a,b);
        assertArrayEquals(expect, result);
    }
    @Test
    public void test5() {
        int[] a = new int[] {1,2,2,1};
        int[] b = new int[] {2};
        int[] expect = new int[] {2};
        IntersectionOfTwoArraysII i = new IntersectionOfTwoArraysII();
        int[] result = i.intersect(a,b);
        assertArrayEquals(expect, result);
    }
    @Test
    public void test6() {
        int[] a = new int[] {3,1,2};
        int[] b = new int[] {1,1};
        int[] expect = new int[] {1};
        IntersectionOfTwoArraysII i = new IntersectionOfTwoArraysII();
        int[] result = i.intersect(a,b);
        assertArrayEquals(expect, result);
    }
    @Test
    public void test7() {
        int[] a = new int[] {1,2,2,1};
        int[] b = new int[] {1,1};
        int[] expect = new int[] {1,1};
        IntersectionOfTwoArraysII i = new IntersectionOfTwoArraysII();
        int[] result = i.intersect(a,b);
        assertArrayEquals(expect, result);
    }
}