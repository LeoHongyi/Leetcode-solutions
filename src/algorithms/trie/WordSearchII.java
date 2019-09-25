package algorithms.trie;
import java.util.List;
import java.util.ArrayList;

/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/431
 * Method: algorithms.depthFirstSearch, trie tree
 * 	 solution 1(brutal force): each character has a target in the dictionary pattern to follow.
 * 	 algorithms.depthFirstSearch recursion tree, time: O(k*m*n*4^l)
 * 	 solution 2(Optimized): trie + dfs backTracking,
 * 	 step 1: Build trie, using all words in dictionary
 * 	 step 2: for for i,j, run a algorithms.depthFirstSearch starting from (i, j) to find all words in the trie
 * 	 case 1: board[x][y] is in cur.children, explore four directions
 * 	 case 2: ... is not in cur.children, return
 * 	 time: (k*l) + (m*n*^l)
 * 	 1. How many levels?
 * 	 Height of trie.
 * 	 2. What do we do at each level?
 * 	 Try to match current cell with current trie node's children
 * 	 3. What are all possible ways for each level going the next?
 * 	 If match, then explore 4 directions,
 * 	 otherwise, stop, return.
 */
public class WordSearchII {
	class TrieNode {
		TrieNode[] children = new TrieNode[26];
		String word;
	}
	private final int[][] DIRECTIONS = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	public List<String> findWords(char[][] board, String[] words) {
		// Write your solution here
		List<String> ret = new ArrayList<>();
		TrieNode root = buildTrie(words);
		for(int i = 0; i < board.length; ++i) {
			for(int j = 0; j < board[0].length; ++j) {
				dfs(board, i, j, root, ret);
			}
		}

		return ret;
	}
	private TrieNode buildTrie(String[] words) {
		TrieNode root = new TrieNode();
		for(String word: words) {
			TrieNode temp = root;
			for(int i = 0; i < word.length(); ++i) {
				if(temp.children[word.charAt(i) - 'a'] == null) {
					temp.children[word.charAt(i) - 'a'] = new TrieNode();
				}
				temp = temp.children[word.charAt(i) - 'a'];
			}
			temp.word = word;
		}
		return root;
	}
	private void dfs(char[][] board, int i, int j, TrieNode parent, List<String> result){
		char c = board[i][j];
		if(c == '#' || parent.children[board[i][j] - 'a'] == null) {
			return;
		}
		TrieNode curNode = parent.children[board[i][j] - 'a'];
		if(curNode.word != null) {
			result.add(curNode.word);
			curNode.word = null;
		}
		board[i][j] = '#';
		for(int[] direction: DIRECTIONS) {
			int nextI = i + direction[0];
			int nextJ = j + direction[1];
			if(isValid(nextI, nextJ, board)) {
				dfs(board, nextI, nextJ, curNode, result);
			}
		}
		board[i][j] = c;
	}
	private boolean isValid(int i, int j, char[][] board) {
		return i >= 0 && i < board.length && j >= 0 && j < board[0].length;
	}

	class TrieNodeII {
		TrieNodeII[] children = new TrieNodeII[26]; // size 26 array, each index -> character, 'c': 'c' - 'a' = 2
		boolean isWord;
	}
//	private final int[][] DIRECTIONS = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	public List<String> findWordsII(char[][] board, String[] words) {
		// Write your solution here
		List<String> result = new ArrayList<>();
		// sanity check
		if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) {
			throw new IllegalArgumentException("Invalid input");
		}
		// step 1: build trie
		TrieNodeII root = buildTrieII(words);
		final int rows = board.length;
		final int cols = board[0].length;
		// from every cell try to find the word corresponding to the part start from the current cell
		boolean[][] visited = new boolean[rows][cols];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				findWordsDFS(root, board, i, j, sb, result, visited);
			}
		}
		return result;
	}
	private void findWordsDFS(TrieNodeII root, char[][] board, int x, int y, StringBuilder sb,
							  List<String> result, boolean[][] visited){
		// base case
		if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y]) {
			return;
		}
		char ch = board[x][y];
		if (root.children[ch - 'a'] == null) {
			return;
		}
		// recursive rule
		root = root.children[ch - 'a'];
		sb.append(ch);
		if (root.isWord) {
			result.add(sb.toString());
		}
		visited[x][y] = true;
		for (int[] dir : DIRECTIONS) {
			int neiX = dir[0] + x;
			int neiY = dir[1] + y;
			findWordsDFS(root, board, neiX, neiY, sb, result, visited);
		}
		visited[x][y] = false;
		sb.deleteCharAt(sb.length() - 1);
	}
	// for each word in words, insert into the trie
	private TrieNodeII buildTrieII(String[] words) {
		TrieNodeII root = new TrieNodeII();
		TrieNodeII cur = root;
		for (String word : words) {
			// sanity check, assume word is not in the trie
			for (int i = 0; i < word.length(); i++) {
				TrieNodeII next = cur.children[word.charAt(i) - 'a'];
				if (next == null) {
					next = new TrieNodeII();
					cur.children[word.charAt(i) - 'a'] = next;
				}
				cur = next;
			}
			cur.isWord = true;
		}
		return root;
	}
}