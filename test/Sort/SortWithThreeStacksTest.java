package Sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class SortWithThreeStacksTest {

    @Test
    public void testSelect1() {
        LinkedList<Integer> s1 =
                new LinkedList<>(Arrays.asList(5,6,3,12,1,8,2));
        LinkedList<Integer> s2 =
                new LinkedList<>(Arrays.asList(1,2,3,5,6,8,12));
        SortWithThreeStacks sort = new SortWithThreeStacks();
        sort.selectionSortWithThreeStacks(s1);
        for (int i = 0; i < s1.size(); i++) {
            assertEquals(s1.get(i), s2.get(i));
        }
        return;
    }
    @Test
    public void testSelect2() {
        LinkedList<Integer> s1 =
                new LinkedList<>(Arrays.asList(5,6,7,3,2,1));
        LinkedList<Integer> s2 =
                new LinkedList<>(Arrays.asList(1,2,3,5,6,7));
        SortWithThreeStacks sort = new SortWithThreeStacks();
        sort.selectionSortWithThreeStacks(s1);
        for (int i = 0; i < s1.size(); i++) {
            assertEquals(s1.get(i), s2.get(i));
        }
        return;
    }
    @Test
    public void testSelect3() {
        LinkedList<Integer> s1 =
                new LinkedList<>(Arrays.asList(4, 2, 1, 1, 3, 2));
        LinkedList<Integer> s2 =
                new LinkedList<>(Arrays.asList(1,1,2,2,3,4));
        SortWithThreeStacks sort = new SortWithThreeStacks();
        sort.selectionSortWithThreeStacks(s1);
        for (int i = 0; i < s1.size(); i++) {
            assertEquals(s1.get(i), s2.get(i));
        }
        return;
    }
    @Test
    public void testMerge1() {
        LinkedList<Integer> s1 =
                new LinkedList<>(Arrays.asList(5,6,3,12,1,8,2));
        LinkedList<Integer> s2 =
                new LinkedList<>(Arrays.asList(1,2,3,5,6,8,12));
        SortWithThreeStacks sort = new SortWithThreeStacks();
        sort.mergeSortWithThreeStacks(s1);
        for (int i = 0; i < s1.size(); i++) {
            assertEquals(s1.get(i), s2.get(i));
        }
        return;
    }
    @Test
    public void testMerge2() {
        LinkedList<Integer> s1 =
                new LinkedList<>(Arrays.asList(5,6,7,3,2,1));
        LinkedList<Integer> s2 =
                new LinkedList<>(Arrays.asList(1,2,3,5,6,7));
        SortWithThreeStacks sort = new SortWithThreeStacks();
        sort.mergeSortWithThreeStacks(s1);
        for (int i = 0; i < s1.size(); i++) {
            assertEquals(s1.get(i), s2.get(i));
        }
        return;
    }
    @Test
    public void testMerge3() {
        LinkedList<Integer> s1 =
                new LinkedList<>(Arrays.asList(4, 2, 1, 1, 3, 2));
        LinkedList<Integer> s2 =
                new LinkedList<>(Arrays.asList(1,1,2,2,3,4));
        SortWithThreeStacks sort = new SortWithThreeStacks();
        sort.mergeSortWithThreeStacks(s1);
        for (int i = 0; i < s1.size(); i++) {
            assertEquals(s1.get(i), s2.get(i));
        }
        return;
    }
}