package algorithms.breadthFirstSearch;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class RobortCleanObstacle {
    public int remove(int numRows, int numColumns, List<List<Integer>> lots) {
        int[][] m = new int[numRows][numColumns];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                m[i][j] = lots.get(i).get(j);
            }
        }
        Queue<Node> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[m.length][m[0].length];
        q.offer(new Node(0, 0));
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            step++;
            while (size > 0) {
                Node curr = q.poll();
                int x = curr.x;
                int y = curr.y;
                if (isValid(m, x + 1, y) && !visited[x + 1][y]) {
                    if (m[x + 1][y] == 9) {
                        return step;
                    } else if (m[x + 1][y] == 1){
                        visited[x + 1][y] = true;
                        q.offer(new Node(x + 1, y));
                    }
                }
                if (isValid(m, x - 1, y) && !visited[x - 1][y]) {
                    if (m[x - 1][y] == 9) {
                        return step;
                    } else if (m[x - 1][y] == 1){
                        visited[x - 1][y] = true;
                        q.offer(new Node(x - 1, y));
                    }
                }
                if (isValid(m, x, y + 1) && !visited[x][y + 1]) {
                    if (m[x][y + 1] == 9) {
                        return step;
                    } else if (m[x][y + 1] == 1){
                        visited[x][y + 1] = true;
                        q.offer(new Node(x, y + 1));
                    }
                }
                if (isValid(m, x, y - 1) && !visited[x][y - 1]) {
                    if (m[x][y - 1] == 9) {
                        return step;
                    } else if (m[x][y - 1] == 1){
                        visited[x][y - 1] = true;
                        q.offer(new Node(x, y - 1));
                    }
                }
                size--;
            }
        }
        return -1;
    }
    private static boolean isValid(int[][] m, int x, int y) {
        return x >= 0 && x < m.length && y >= 0 && y < m[0].length;
    }
}
class Node {
    int x;
    int y;
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

/*
    Method: Breadth First Search
    For each current point that is now valid and not visited,
    do a four directions search.
    Apply the same rule for the search the next point.
    n = rows, m = cols
    worst case: time: O(n * m), space: stack O(n * m) + heap: matrix: O(n * m) +
    visited O(n * m) + Queue O(n * m)= O(n * m)
*/



/*
    method: find the first space, determine if the following char is digit or letter
    If char > '9',letter, then is prime.
    If char <= '9', digit, then is not prime.
    If tie, then compare the later part after the space,
    If tie, then compare the former part of the identifier.
    worst case: time: O(n)，space O(1)
*/