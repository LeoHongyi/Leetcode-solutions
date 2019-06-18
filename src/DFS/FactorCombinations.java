package DFS;
import java.util.List;
import java.util.ArrayList;
/**
	Assumption: the taget can be negative. must be >= 1
	Method: DFS
	example: 12
	1. How many levels in the recursion tree? What does it store on each level?
	6,4,3,2
	2. How many different states should we try to put on each level?
	depends on the remaining factor of the target
 **/
public class FactorCombinations {
	public List<List<Integer>> combinations(int target) {
		// Write your solution here
		List<List<Integer>> result = new ArrayList<>();
		if (Math.abs(target) <= 1) {
			return result;
		}
		List<Integer> factorList = getFactorList(target);
		List<Integer> cur = new ArrayList<>();
		findCombDFS((double)target, 0, factorList, cur, result);
		return result;
	}
	private void findCombDFS(double target, int level, List<Integer> factorList,
							 List<Integer> cur, List<List<Integer>> result) {
		// base case, when level reaches the factorList.size() or if remainingTarget == 1 add into result
		if (level == factorList.size() || target == 1.0) {
			if (target == 1.0) {
				result.add(new ArrayList<>(cur));
			}
			return;
		}
		// for each level try all possible factorList[i] with different numbers
		int curFactor = factorList.get(level);
		for (int i = 0; Math.pow(curFactor, i) <= target && (target % Math.pow(curFactor, i)) == 0; i++) {
//		for (int i = 0; i <= Math.log(target) / Math.log(curFactor); i++) {
			// mark the size of last level
			double tempTarget = target;
			int curIndex = cur.size();
			for (int j = 0; j < i; j++) {
				cur.add(curFactor);
				target /= (double)curFactor;

			}
			findCombDFS(target, level + 1, factorList, cur, result);
			cur = cur.subList(0, curIndex);
			target = tempTarget;
		}
	}
	private List<Integer> getFactorList(int target) {
		List<Integer> list = new ArrayList<>();
		for (int i = 2; i <= target / 2; i++) {
			if (target % i == 0) {
				list.add(i);
			}
		}
		return list;
	}
}
