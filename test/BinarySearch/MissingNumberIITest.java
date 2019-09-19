package BinarySearch;

import org.junit.Test;

import static org.junit.Assert.*;

public class MissingNumberIITest {
    @Test
    public void test1() {
        int[] input = new int[] {1,2,3,4,5,6,8};
        MissingNumberII mn = new MissingNumberII();
        int result = mn.missing(input);
        assertEquals(7, result);
    }
    @Test
    public void test2() {
        int[] input = new int[] {};
        MissingNumberII mn = new MissingNumberII();
        int result = mn.missing(input);
        assertEquals(1, result);
    }
    @Test
    public void test3() {
        int[] input = new int[] {1,3};
        MissingNumberII mn = new MissingNumberII();
        int result = mn.missing(input);
        assertEquals(2, result);
    }
    @Test
    public void test4() {
        int[] input = new int[] {1,2,3,4,5,6,8};
        MissingNumberII mn = new MissingNumberII();
        int result = mn.binarySearchMissing(input);
        assertEquals(7, result);
    }
    @Test
    public void test5() {
        int[] input = new int[] {};
        MissingNumberII mn = new MissingNumberII();
        int result = mn.binarySearchMissing(input);
        assertEquals(1, result);
    }
    @Test
    public void test6() {
        int[] input = new int[] {1,3};
        MissingNumberII mn = new MissingNumberII();
        int result = mn.binarySearchMissing(input);
        assertEquals(2, result);
    }
    @Test
    public void test7() {
        int[] input = new int[] {1,2,3,4};
        MissingNumberII mn = new MissingNumberII();
        int result = mn.binarySearchMissing(input);
        assertEquals(5, result);
    }
    @Test
    public void test8() {
        int[] input = new int[] {2,3,4,5,6,7};
        MissingNumberII mn = new MissingNumberII();
        int result = mn.binarySearchMissing(input);
        assertEquals(1, result);
    }
}