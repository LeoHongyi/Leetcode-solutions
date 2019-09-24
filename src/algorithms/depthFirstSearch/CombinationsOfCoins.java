package algorithms.depthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class CombinationsOfCoins {
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/73
 * Method: DFS, num of levels: coins array.length,
 * each level decide how many of coins[i] can be added
 * Assumption: target >= 0,
 * coins[i] have infinite number for each of the denominations.
 */
    public List<List<Integer>> combinations(int target, int[] coins) {
        // Write your solution here
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        DFS(target, coins, 0, cur, result);
        return result;
    }
    private void DFS(int remainTarget, int[] coins, int level, List<Integer> cur, List<List<Integer>> result) {
        if (level == coins.length) {
            if (remainTarget == 0) {
                result.add(new ArrayList(cur));
            }
            return;
            // else don't save the cur in result.
        }
        for (int i = 0; i * coins[level] <= remainTarget; i++) {
            // add the solution in the cur
            cur.add(i);
            DFS(remainTarget - i * coins[level], coins, level + 1, cur, result);
            // remove the solution in the cur
            cur.remove(cur.size() - 1);
        }
    }
}
