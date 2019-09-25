package algorithms.depthFirstSearch;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/233
 */
public class NQueens {
    public List<List<Integer>> nqueens(int n) {
        // Write your solution here
        List<List<Integer>> result = new ArrayList<>();
        // use int[] instead of List<Integer> for easier change of value,
        int[] cur = new int[n];
        boolean[] usedColumns = new boolean[n];
        boolean[] usedDiagonals = new boolean[n * 2 - 1];
        boolean[] usedRevDiagonals = new boolean[n * 2 - 1];
        DFS(n, result, cur, 0, usedColumns, usedDiagonals, usedRevDiagonals);
        return result;
    }
    private void DFS(int n, List<List<Integer>> result, int[] cur, int row,
                     boolean[] usedColumns, boolean[] usedDiagonals, boolean[] usedRevDiagonals) {
        if (row == n) {
            result.add(toList(cur));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (valid(n, row, i, usedColumns, usedDiagonals, usedRevDiagonals)) {
                mark(n, row, i, usedColumns, usedDiagonals, usedRevDiagonals);
                cur[row] = i;
                DFS(n, result, cur, row + 1, usedColumns, usedDiagonals, usedRevDiagonals);
                unMark(n, row, i, usedColumns, usedDiagonals, usedRevDiagonals);
            }
        }
    }
    private boolean valid(int n, int row, int col, boolean[] usedColumns, boolean[] usedDiagonals,
                          boolean[] usedRevDiagonals) {
        return !usedColumns[col] && !usedDiagonals[row + col] && !usedRevDiagonals[col - row + n - 1];
    }
    private void mark(int n, int row, int col, boolean[] usedColumns, boolean[] usedDiagonals,
                      boolean[] usedRevDiagonals) {
        usedColumns[col] = true;
        usedDiagonals[row + col] = true;
        usedRevDiagonals[col - row + n - 1] = true;
    }
    private void unMark(int n, int row, int col, boolean[] usedColumns, boolean[] usedDiagonals,
                        boolean[] usedRevDiagonals) {
        usedColumns[col] = false;
        usedDiagonals[row + col] = false;
        usedRevDiagonals[col - row + n - 1]= false;
    }
    private List<Integer> toList(int[] cur) {
        List<Integer> list = new ArrayList<>();
        for (int num : cur) {
            list.add(num);
        }
        return list;
    }
}
