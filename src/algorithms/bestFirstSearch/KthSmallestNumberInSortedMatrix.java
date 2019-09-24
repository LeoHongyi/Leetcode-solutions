package algorithms.bestFirstSearch;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestNumberInSortedMatrix {
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/26
 * Method: BFS2 Best First Search, Dijstra's algorithm,
 *  find the shortest path cost from a single node to any other nodes in that graph
 *  data structure: minHeap
 *  time: O(klogk)
 *  space: O(n*M)
 *  Assumption: matrix is not null, N * M where N > 0 and M > 0
 *  K > 0 and K <= N * M
 */
    public int kthSmallest(int[][] matrix, int k) {
        // Write your solution here
        int r = matrix.length;
        int c = matrix[0].length;
        // Best First Search,  need a minHeap on the value of each cells.
        PriorityQueue<Cell> minHeap = new PriorityQueue<Cell>(k, new Comparator<Cell>() {
            @Override
            public int compare(Cell c1, Cell c2) {
                if (c1.val < c2.val) {
                    return -1;
                } else if (c1.val > c2.val) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        // all the generated cells will be marked true,
        // to avoid being generated more than once.
        boolean[][] visited = new boolean[r][c];
        minHeap.offer(new Cell(0, 0, matrix[0][0]));
        visited[0][0] = true;
        // iterate k - 1 rounds, and Best First Search the smallest k - 1 cells.
        for (int i = 0; i < k - 1; i++) {
            Cell cur = minHeap.poll();
            // the neighbor cell will be inserted back to the minHeap only if
            // 1. it is not out of boundary.
            // 2. it has not been generated before.
            // Because for each cell, it could be generated twice.
            if (cur.row + 1 < r && !visited[cur.row + 1][cur.col]) {
                minHeap.offer(new Cell(cur.row + 1, cur.col, matrix[cur.row + 1][cur.col]));
                visited[cur.row + 1][cur.col] = true;
            }
            if (cur.col + 1 < c && !visited[cur.row][cur.col + 1]) {
                minHeap.offer(new Cell(cur.row, cur.col + 1, matrix[cur.row][cur.col + 1]));
                visited[cur.row][cur.col + 1] = true;
            }
        }
        return minHeap.peek().val;
    }
    static class Cell {
        int row;
        int col;
        int val;
        Cell(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }
}
