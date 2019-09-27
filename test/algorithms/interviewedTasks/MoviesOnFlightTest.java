package algorithms.interviewedTasks;

import org.junit.Test;

import static org.junit.Assert.*;

public class MoviesOnFlightTest {
    @Test
    public void testPickMovies() {
        int[] array = new int[] {90, 85, 75, 60, 120, 150, 125};
        int duration = 250;
        int[] exp = new int[] {0, 6};
        MoviesOnFlight mv = new MoviesOnFlight();
        int[] result = mv.pickMovie(array, duration);
        assertArrayEquals(exp, result);
    }
}