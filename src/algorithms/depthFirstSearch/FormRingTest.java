package algorithms.depthFirstSearch;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FormRingTest {
	FormRing ob;

	@Before
	public void setUp() {
		ob = new FormRing();
	}
	@Test
	public void test1() {
		String[] array1 = {"aaa", "bbb", "baa", "aab"};
		assertTrue(ob.formRing(array1));
	}
	@Test
	public void test2() {
		String[] array2 = {"aaa", "bbb", "baa"};
		assertFalse(ob.formRing(array2));
	}
	@Test
	public void test3() {
		String[] array3 = {"aab","cca","bac","bab"};
		assertTrue(ob.formRing(array3));
	}
	@Test
	public void test4() {
		String[] array4 = {"a","bc","c","ddb","cd","ba","aad"};
		assertFalse(ob.formRing(array4));
	}

	@Test
	public void formRing() {
	}
}