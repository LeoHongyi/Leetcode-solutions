package Algorithms.Trie;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.Assert;

public class WordSearchIITest {
	char[][] board = new char[][] {
			{'a','a','a','a'},
			{'a','a','a','a'},
			{'a','a','a','a'},
			{'a','a','a','a'},
			{'b','c','d','e'},
			{'f','g','h','i'},
			{'j','k','l','m'},
			{'n','o','p','q'},
			{'r','s','t','u'},
			{'v','w','x','y'},
			{'z','z','z','z'}};
	String[] words = new String[] {"aaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaab","aaaaaaaaaaaaaaac","aaaaaaaaaaaaaaad","aaaaaaaaaaaaaaae","aaaaaaaaaaaaaaaf","aaaaaaaaaaaaaaag","aaaaaaaaaaaaaaah","aaaaaaaaaaaaaaai","aaaaaaaaaaaaaaaj","aaaaaaaaaaaaaaak","aaaaaaaaaaaaaaal","aaaaaaaaaaaaaaam","aaaaaaaaaaaaaago","aaaaaaaaaaaaaagp","aaaaaaaaaaaaaagq","aaaaaaaaaaaaaagr","aaaaaaaaaaaaaags","aaaaaaaaaaaaaagt","aaaaaaaaaaaaaagu","aaaaaaaaaaaaaagv","aaaaaaaaaaaaaagw","aaaaaaaaaaaaaagx","aaaaaaaaaaaaaagy","aaaaaaaaaaaaaagz","aaaaaaaaaaaaaaha","aaaaaaaaaaaaaahb","aaaaaaaaaaaaaahc","aaaaaaaaaaaaaahd","aaaaaaaaaaaaaahe","aaaaaaaaaaaaaahf","aaaaaaaaaaaaaahg","aaaaaaaaaaaaaahh","aaaaaaaaaaaaaahi","aaaaaaaaaaaaaall"};
	List<String> expectResult = Arrays.asList("aaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaab","aaaaaaaaaaaaaaac","aaaaaaaaaaaaaaad","aaaaaaaaaaaaaaae");

	@Test
	void testFindWords() {
		WordSearchII ws = new WordSearchII();
		List<String> result1 = ws.findWords(board, words);
		if (result1.size() != expectResult.size()) {
			throw new IndexOutOfBoundsException("Expect result size: " + expectResult.size() + " But is: " + result1.size());
		} else {
			for (int i = 0; i < result1.size(); i++) {
				Assert.assertEquals(result1.get(i), expectResult.get(i));
			}
		}
	}
	@Test
	void testFindWordsII() {
		WordSearchII ws = new WordSearchII();
		List<String> result2 = ws.findWords(board, words);
		if (result2.size() != expectResult.size()) {
			throw new IndexOutOfBoundsException("Expect result size: " + expectResult.size() + " But is: " + result2.size());
		} else {
			for (int i = 0; i < result2.size(); i++) {
				Assert.assertEquals(result2.get(i), expectResult.get(i));
			}
		}
	}
}
