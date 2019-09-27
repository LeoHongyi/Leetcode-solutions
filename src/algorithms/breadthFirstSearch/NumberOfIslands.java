package algorithms.breadthFirstSearch;
/**
 * @author Qihao He
 * @date 09/26/2019
 * https://app.laicode.io/app/problem/525
 * https://leetcode.com/problems/number-of-islands/
 */
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    /**
     * Method: BFS
     */
    public int numIslandsBFS(char[][] grid) {
        // Write your solution here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        final int rows = grid.length;
        final int cols = grid[0].length;
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    bfs(grid, new Point(i, j));
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, Point start) {
        Queue<Point> queue = new LinkedList<>();
        int[] dirX = new int[]{1, 0, -1, 0};
        int[] dirY = new int[]{0, 1, 0, -1};

        queue.offer(start);
        while (!queue.isEmpty()) {
            Point curr = queue.poll();
            grid[curr.row][curr.col] = '0';
            // this is belong to island, we mark as visted
            for (int i = 0; i < dirX.length; i++) {
                int newRow = curr.row + dirX[i];
                int newCol = curr.col + dirY[i];
                if (inBound(newRow, newCol, grid) && grid[newRow][newCol] == '1') {
                    queue.offer(new Point(newRow, newCol));
                }
            }
        }
    }

    private boolean inBound(int row, int col, char[][] grid) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }

    /**
     * Method: DFS
     * worst case: time: O(n^2), space: O(n^2)
     * average case: time: O(n^2), space O(1)
     * time: O(V + E)
     */
    final static int[][] dirs = {{-1, 0},{1, 0},{0, -1},{0, 1}};
    public int numIslandsDFS(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j, rows, cols);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int x, int y, int rows, int cols) {
        // base case
        if (x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == '0') {
            return;
        }
        /**
         * recursive rule
         * mark as visisted,
         * traverse in four directions.
         */
        grid[x][y] = '2';
        for (int[] dir : dirs) {
            int neiX = dir[0] + x;
            int neiY = dir[1] + y;
            dfs(grid, neiX, neiY, rows, cols);

        }
    }
}

class Point {
    int row;
    int col;
    public Point(int row, int col) {
        this.row = row;
        this.col = col;
    }
}