package DP;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CutNumberTest {
	CutNumber sn;
	@Before
	public void setUp() {
		sn = new CutNumber();
	}
	@Test
	public void test4() {
		assertEquals(sn.cutNumber(4), 1);
	}
	@Test
	public void test10() {
		assertEquals(sn.cutNumber(10), 2);
	}
}