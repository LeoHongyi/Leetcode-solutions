package algorithms.breadthFirstSearch;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/200
 * For every point Pi <xi, yi, zi> on the border, se the water level to <zi>
 *  Fro every point Pj not on the border set the water level to infinity
 *  Insert all Pi into MIN_HEAP (= set of active points)
 *  Method: Best First Search
 *  While (MIN_HEAP is not empty)
 *  P = MIN_HEAP.pop() // Select the active point P with minimum level
 *  SUM += Level(P) - Height(P);
 *  For every point Q adjacent to P:
 *  if Level(Q) is infinity: // dedup
 *  Level(Q) = max(Height(Q), Level(P))
 *  Add Q to the MIN_HEAP
 */
public class MaxWaterTrapperII {
    public int maxTrapped(int[][] matrix) {
        // Write your solution here
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (rows < 3 || cols < 3) {
            return 0;
        }
        PriorityQueue<Pair> minHeap = new PriorityQueue<>();
        boolean[][] visited = new boolean[rows][cols];
        // put all the border cells of the matrix at the beginning.
        processBorder(matrix, visited, minHeap, rows, cols);
        int result = 0;
        while (!minHeap.isEmpty()) {
            Pair cur = minHeap.poll();
            // get all possible neighbor cells.
            List<Pair> neighbors = allNeighbors(cur, matrix, visited);
            for (Pair nei : neighbors) {
                // if any neighbor has been visited before, we just ignore.
                if (visited[nei.x][nei.y]) {
                    continue;
                }
                // adjust the neighbor cell's height to the current water level
                // if necessary, mark the neighbor cell as visited, and put the
                // neighbor cell into the minHeap.
                visited[nei.x][nei.y] = true;
                // how much water can be trapped at the neighbor cell.
                // the maximum water level currently is controlled by the cur cell.
                result += Math.max(cur.height - nei.height, 0);
                nei.height = Math.max(cur.height, nei.height);
                minHeap.offer(nei);
            }
        }
        return result;
    }
    // put all the border cells into the min Heap at the very beginning,
    // these are the start points of the whole BFS process.
    private void processBorder(int[][] matrix, boolean[][] visited,
                               PriorityQueue<Pair> minHeap, int rows, int cols) {
        // 1st and last rows
        for (int j = 0; j < cols; j++) {
            minHeap.offer(new Pair(0, j, matrix[0][j]));
            minHeap.offer(new Pair(rows - 1, j, matrix[rows - 1][j]));
            visited[0][j] = true;
            visited[rows - 1][j] = true;
        }
        // 1st and last cols, exclude the added ones
        for (int i = 1; i < rows - 1; i++) {
            minHeap.offer(new Pair(i, 0, matrix[i][0]));
            minHeap.offer(new Pair(i, cols - 1, matrix[i][cols - 1]));
            visited[i][0] = true;
            visited[i][cols - 1] = true;
        }
    }
    // find all neighbors in list
    private List<Pair> allNeighbors(Pair cur, int[][] matrix, boolean[][] visited) {
        List<Pair> neis = new ArrayList<>();
        if (cur.x + 1 < matrix.length) {
            neis.add(new Pair(cur.x + 1, cur.y, matrix[cur.x + 1][cur.y]));
        }
        if (cur.x - 1 >= 0) {
            neis.add(new Pair(cur.x - 1, cur.y, matrix[cur.x - 1][cur.y]));
        }
        if (cur.y + 1 < matrix[0].length) {
            neis.add(new Pair(cur.x, cur.y + 1, matrix[cur.x][cur.y + 1]));
        }
        if (cur.y - 1 >= 0) {
            neis.add(new Pair(cur.x, cur.y - 1, matrix[cur.x][cur.y - 1]));
        }
        return neis;
    }
    static class Pair implements Comparable<Pair>{
        int x;
        int y;
        int height;
        Pair(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }
        @Override
        public int compareTo(Pair another) {
            if (this.height == another.height) {
                return 0;
            }
            return this.height < another.height ? -1 : 1;
        }
    }
}
