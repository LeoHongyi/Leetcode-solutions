package algorithms.trie;
import java.util.Map;
import java.util.HashMap;

class TrieNode {
	private final Map<Character, TrieNode> children = new HashMap<>();
	private boolean endOfWord;

	Map<Character, TrieNode> getChildren() {
		return children;
	}

	boolean isEndOfWord() {
		return endOfWord;
	}

	void setEndOfWord(boolean endOfWord) {
		this.endOfWord = endOfWord;
	}
}