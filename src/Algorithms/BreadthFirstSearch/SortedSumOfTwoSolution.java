package Algorithms.BreadthFirstSearch;
/**
 * #5 Given two sorted arrays A and B, with their sizes to be m and n, respectively.
 * We can pick one element a from A and the other element b from B,
 * and their sum s is defined to be s = a + b.
 * How to find k-th smallest s from all possible values of s.
 * Assumption: k < m * n. e.g. A = {1, 3, 5}, B = {2, 3}, k = 1, the result is A[0] + B[0] = 3 k = 2,
 * the result is A[0] + B[1] = 4 k = 3, the result is A[1] + B[0] = 5
 *
 * Assumption:
 * sorted!
 * but array a and array b cannot be null! But length == 0 is allowed.
 * any sum cannot be out of the integer's range/bound. It there is some large sum,
 * change the key type and return type to be double
 * only want the sum, not how we get it.
 *
 * Method: Dijkstra algorithm
 * Kth smallest number in sorted matrix
 *			1		4		5		A
 *	2		3		6		7
 *	3		4		7		8
 *	6		7		10	11
 *	B
 * matrix[i][j] = B[i] + A[j]
 * 0. represent the state: <i, j> = B[i] + A[j]
 * 1. initial state<0, 0>
 * 2. generation rule:
 * 					<i + 1, j>
 * 					<i, j + 1>
 * 3. deduplication
 * Do we need to populate the matrix at the beginning? No
 * **/
public class SortedSumOfTwoSolution {
	public int sortedSumOfTwo(int[] a, int[] b, int k){
		return dijk(a, b, k);
	}
	private int dijk(int[] a, int[] b, int k) {
		PriorityQueue<Tuple> minHeap = new PriorityQueue<Tuple>(k, new Comparator<Tuple>() {
			@Override
			public int compare(Tuple t1, Tuple t2) {
				if (t1.key < t2.key) {
					return -1;
				} else if (t1.key > t2.key) {
					return 1;
				} else {
					return 0;
				}
			}
		});
		boolean[][] visited = new boolean[a.length][b.length];
		visited[0][0] = true;
		minHeap.offer(new Tuple(0, 0, a[0] + b[0]));
		while (k > 1) {
			k--;
			Tuple cur = minHeap.poll();
			int i = cur.x;
			int j = cur.y;
			if (i + 1 < a.length && !visited[i + 1][j]) {
				minHeap.offer(new Tuple(i + 1, j, a[i + 1] + b[j]));
				visited[i + 1][j] = true;
			}
			if (j + 1 < b.length && !visited[i][j + 1]) {
				minHeap.offer(new Tuple(i, j + 1, a[i] + b[j + 1]));
				visited[i][j + 1] = true;
			}
		}
		return minHeap.peek().key;
	}

	Class Tuple{
		int x;
		int y;
		int key;
		public Tuple(int x, int y, int key) {
			this.x = x;
			this.y = y;
			this.key = key;
		}
	}
}
