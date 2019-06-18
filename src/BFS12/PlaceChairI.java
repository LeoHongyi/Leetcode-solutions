package BFS12;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.ArrayDeque;
/**
 Method: Breadth First Search
 **/
public class PlaceChairI {
	private static final char EQUIP = 'E';
	private static final char OB = 'O';
	private static final char CH = 'C';
	public List<Integer> putChair(char[][] gym) {
		// Write your solution here
		if (gym == null || gym.length == 0 || gym[0].length == 0) {
			return new ArrayList<>();
		}
		List<Integer> result = Arrays.asList(-1, -1);
		int rows = gym.length;
		int cols = gym[0].length;
		int numEquip = 0;
		int[][] reach = new int[rows][cols];
		int[][] distance = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (gym[i][j] == EQUIP) {
					numEquip++;
					BFS(i, j, reach, distance, gym);
				}
			}
		}
		int curMin = Integer.MAX_VALUE;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (reach[i][j] == numEquip && gym[i][j] == CH) {
					if (distance[i][j] < curMin) {
						curMin = distance[i][j];
						result = Arrays.asList(i, j);
					}
				}
			}
		}
		return result;
	}
	private void BFS(int i, int j, int[][] reach, int[][] distance, char[][] matrix) {
		Queue<Cell> queue = new ArrayDeque<>();
		boolean[][] visited = new boolean[reach.length][reach[0].length];
		reach[i][j]++;
		visited[i][j] = true;
		queue.offer(new Cell(i, j));
		int level = 1;
		int[][] DIR = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int x = 0; x < size; x++) {
				Cell cur = queue.poll();
				for (int[] dir : DIR) {
					int nextRow = cur.x + dir[0];
					int nextCol = cur.y + dir[1];
					if (isValid(nextRow, nextCol, visited, matrix)) {
						reach[nextRow][nextCol]++;
						visited[nextRow][nextCol] = true;
						distance[nextRow][nextCol] += level;
						queue.offer(new Cell(nextRow, nextCol));
					}
				}
			}
			level++;
		}
	}
	private boolean isValid(int i, int j, boolean[][] visited, char[][] matrix){
		if (i < 0 || j < 0 || i >= visited.length || j >= visited[0].length ||
				visited[i][j] || matrix[i][j] == OB) {
			return false;
		}
		return true;
	}
	class Cell {
		int x;
		int y;
		public Cell(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
