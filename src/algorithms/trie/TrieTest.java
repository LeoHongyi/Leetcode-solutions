package algorithms.trie;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TrieTest {
	Trie trie;
	@Before
	public void setUp() {
		trie = new Trie();
	}
	@Test
	public void test1() {
		assertTrue(trie.containsNode("Programming"));

		trie.delete("Programming");
		assertFalse(trie.containsNode("Programming"));
	}
}