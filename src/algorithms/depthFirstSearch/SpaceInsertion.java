package algorithms.depthFirstSearch;
import java.util.List;
import java.util.ArrayList;
/**
 * Description:
 * Given a string, we can insert at most one empty space between each pair of adjacent letters.
 * Print all permutations of strings after insertions of empty spaces.
 * Input: str = "ABC"
 * Output:
 * ABC
 * AB_C
 * A_BC
 * A_B_C
 *
 * Method: use algorithms.depthFirstSearch for permutation
 * 1. How many levels do we have?
 * n, the length of the string
 * 2. what should we do at each level?
 * add letter or add letter & " "
 * str.length() = n
 * time: O(2^n), space: O(n)
 * **/
public class SpaceInsertion {
	public List<String> spaceInsertion(String input) {
		if (input == null) {
			return null;
		}
		List<String> result = new ArrayList<>();
		permutationDFS(input, 0, new StringBuilder(), result);
		return result;
	}
	private void permutationDFS(String input, int index, StringBuilder cur, List<String> result) {
		// base case
		if (index == input.length() - 1) {
			cur.append(input.charAt(index));
			result.add(cur.toString());
			cur.deleteCharAt(cur.length() - 1);
			return;
		}
		//current level process
		// case 1: add letter and space
		cur.append(input.charAt(index)).append(" ");
		permutationDFS(input, index + 1, cur, result);
		cur.deleteCharAt(cur.length() - 1);
		// case 2: only add letter
		permutationDFS(input, index + 1, cur, result);
		cur.deleteCharAt(cur.length() - 1);
	}
}
