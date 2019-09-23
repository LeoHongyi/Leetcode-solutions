package algorithms.priorityQueue;

public class KthSmallestNumberInSortedMatrix {
	public int kthSmallest(int[][] matrix, int k) {
		// Write your solution here
		int rows = matrix.length;
		int columns = matrix[0].length;
		PriorityQueue<Cell> minHeap = new PriorityQueue<>(k, new MyComparator());
		boolean[][] visited = new boolean[rows][columns];
		minHeap.offer(new Cell(0, 0, matrix[0][0]));
		visited[0][0] = true;
		for (int i = 0; i < k - 1; i++) {
			Cell cur = minHeap.poll();
			if (cur.row + 1 < rows && !visited[cur.row + 1][cur.column]) {
				minHeap.offer(new Cell(cur.row + 1, cur.column, matrix[cur.row + 1][cur.column]));
				visited[cur.row + 1][cur.column] = true;
			}
			if (cur.column + 1 < columns && !visited[cur.row][cur.column + 1]) {
				minHeap.offer(new Cell(cur.row, cur.column + 1, matrix[cur.row][cur.column + 1]));
				visited[cur.row][cur.column + 1] = true;
			}
		}
		return minHeap.peek().value;
	}
	private static class MyComparator implements Comparator<Cell> {
		@Override
		public int compare (Cell c1, Cell c2) {
			if (c1.value == c2.value) {
				return 0;
			}
			return c1.value < c2.value ? -1 : 1;
		}
	}
	static class Cell {
		int row;
		int column;
		int value;
		Cell(int row, int column, int value) {
			this.row = row;
			this.column = column;
			this.value = value;
		}
	}
}
