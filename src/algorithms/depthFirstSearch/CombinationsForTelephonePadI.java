package algorithms.depthFirstSearch;
import java.util.List;
import java.util.ArrayList;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/272
 * Method: DFS
 */
public class CombinationsForTelephonePadI {
	public String[] combinations(int number) {
		// Write your solution here
		String[] array = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		String digits = number + "";
		List<String> list = new ArrayList<>();
		String cur = "";
		combinationsDFS(digits, array, 0, cur, list);
		String[] result = new String[list.size()];
		int i = 0;
		for (String str : list) {
			result[i] = str;
			i++;
		}
		return result;
	}
	private void combinationsDFS(String digits, String[] array, int index,
								 String cur, List<String> list) {
		// base case
		if (index == digits.length()) {
			list.add(cur);
			return;
		}
		// current level
		// get the current level digit
		int digit = digits.charAt(index) - '0';
		if (digit == 0 || digit == 1) {
			String temp =  cur + "";
			combinationsDFS(digits, array, index + 1, temp, list);
		} else {
			for (int i = 0; i < array[digit].length(); i++) {
				String temp = cur + (array[digit].charAt(i));
				combinationsDFS(digits, array, index + 1, temp, list);
			}
		}
	}
}
