package algorithms.iTasks.amXueHan.oa;
/**
 * @author: Qihao He
 * @date: 09/27/2019
 * Assumption: nums can be null, or any length, may have duplicate length,
 * all movie in list are identical.
 * return only one pair when top 1s are tie.
 * Method: 2 sum with no sort, return indexes
 * time: O(n^2), space O(1)
 */

import org.junit.Test;

import static org.junit.Assert.*;

public class MoviesOnFlightTest {
    @Test
    public void test1PickMovies() {
        int[] array = new int[] {90, 85, 75, 60, 120, 150, 125};
        int duration = 250;
        int[] exp = new int[] {0, 6};
        MoviesOnFlight mv = new MoviesOnFlight();
        int[] result = mv.pickMovie(array, duration);
        assertArrayEquals(exp, result);
    }
    @Test
    public void test2PickMovies() {
        int[] array = new int[] {90, 85, 75, 60, 120, 150, 125};
        int duration = 100;
        int[] exp = new int[] {0, 0};
        MoviesOnFlight mv = new MoviesOnFlight();
        int[] result = mv.pickMovie(array, duration);
        assertArrayEquals(exp, result);
    }
    @Test
    public void test3PickMovies() {
        int[] array = new int[] {90, 85, 75, 60, 120, 150, 125};
        int duration = 30;
        int[] exp = new int[] {0, 0};
        MoviesOnFlight mv = new MoviesOnFlight();
        int[] result = mv.pickMovie(array, duration);
        assertArrayEquals(exp, result);
    }
    @Test
    public void test4PickMovies() {
        int[] array = new int[] {90, 85, 75, 60, 120, 150, 125};
        int duration = 150;
        int[] exp = new int[] {0, 0};
        MoviesOnFlight mv = new MoviesOnFlight();
        int[] result = mv.pickMovie(array, duration);
        assertArrayEquals(exp, result);
    }
    @Test
    public void test5PickMovies() {
        int[] array = new int[] {90, 85, 75, 60, 120, 150, 125};
        int duration = 165;
        int[] exp = new int[] {2,3};
        MoviesOnFlight mv = new MoviesOnFlight();
        int[] result = mv.pickMovie(array, duration);
        assertArrayEquals(exp, result);
    }
}