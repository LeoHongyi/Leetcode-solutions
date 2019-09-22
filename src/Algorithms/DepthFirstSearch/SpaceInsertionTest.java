package Algorithms.DepthFirstSearch;

import org.junit.Test;
import java.util.List;
import java.util.Arrays;
import static org.junit.Assert.*;

public class SpaceInsertionTest {
	@Test
	public void test1() {
		String input1 = "ABC";
		List<String> expect1 = Arrays.asList("A B C", "A BC", "AB C", "ABC");
		SpaceInsertion si = new SpaceInsertion();
		List<String> actual1 = si.spaceInsertion(input1);
		if (actual1.size() != expect1.size()) {
			throw new IndexOutOfBoundsException("Expect result size: " + expect1.size() + " But is: " + actual1.size());
		} else {
			for (int i = 0; i < actual1.size(); i++) {
				assertEquals(expect1.get(i), actual1.get(i));
			}
		}
	}
}
