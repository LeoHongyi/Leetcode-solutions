package Algorithms.DepthFirstSearch;
import java.util.List;
import java.util.ArrayList;
/**
 * 	should use indent == 2
 * 				time: O(2^2N)
 * 				space:O(n)
 * **/
public class PrintPossibleBlocks {
	public void printPossibleIfBlocks(int n) {
		List<List<String>> result = new ArrayList<>();
		List<String> cur = new ArrayList<>();
		int left = 0;
		int right = n - 1;
		DFS(n, left, right, cur, result);
		for (List<String> list : result) {
			for (String s : list) {
				System.out.println(s);
			}
		}
		return;
	}
	private void DFS(int n, int left , int right, List<String> cur, List<List<String>> result) {
		if (left == n && right == n) {
			result.add(new ArrayList<>(cur));
		}
		if (left < n) {
			cur.add("if {");
			DFS(n, left + 1, right, cur, result);
			cur.remove(cur.size() - 1);
		}
		if (right < n && right < left) {
			cur.add("}");
			DFS(n, left, right + 1, cur, result);
			cur.remove(cur.size() - 1);
		}
	}
	private void printSolution(char[] array) {
		int heading = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == '{') {
				printSpace(heading);
				System.out.println("if {");
				heading += 2;
			} else {
				heading -= 2;
				printSpace(heading);
				System.out.println("}");
			}
		}
	}
}