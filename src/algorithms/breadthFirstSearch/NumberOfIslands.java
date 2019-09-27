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

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
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
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    dfs(grid, r, c);
                }
            }
        }
        return num_islands;
    }

    private void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
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