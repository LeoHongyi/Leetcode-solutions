package algorithms.depthFirstSearch;
import java.util.List;
import java.util.ArrayList;

public class CombinationSum {
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		// Write your solution here
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> cur = new ArrayList<>();
		if (candidates == null || candidates.length == 0 || target <= 0) {
			return result;
		}
		DFS(candidates, target, 0, cur, result);
		return result;
	}
	private static void DFS(int[] candidates, int targetRemain, int level,
							List<Integer> cur, List<List<Integer>> result) {
		if (level == candidates.length) {
			if (targetRemain == 0) {
				result.add(new ArrayList(cur));
			}
			return;
		}
		for (int i = 0; i * candidates[level] <= targetRemain; i++) {
			for (int j = i; j > 0; j--) {
				cur.add(candidates[level]);
			}
			DFS(candidates, targetRemain - i * candidates[level],
					level + 1, cur, result);
			for (int j = i; j > 0; j--) {
				cur.remove(cur.size() - 1);
			}
		}
	}
}