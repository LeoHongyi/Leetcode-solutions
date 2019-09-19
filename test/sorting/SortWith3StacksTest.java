package sorting;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class SortWith3StacksTest {
    @Test
    public void test1() {
        LinkedList<Integer> s1 =
                new LinkedList<>(Arrays.asList(5,6,3,12,1,8,2));
        LinkedList<Integer> s2 =
                new LinkedList<>(Arrays.asList(1,2,3,5,6,8,12));
        SortWith3Stacks s = new SortWith3Stacks();
        s.sort(s1);
        assertEquals(s2, s1);
    }

}