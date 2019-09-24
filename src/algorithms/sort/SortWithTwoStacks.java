package algorithms.sort;
import java.util.LinkedList;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/280
 * Method: selection sort, use s2 as a buffer and a storage for global MIN,
 *  s1: used for storing all unsorted elements
 *  s2: left part | right part
 *  time: O(n^2)
 *  space: O(n)
 */
public class SortWithTwoStacks {
	public void selectionSortWithTwoStacks(LinkedList<Integer> s1) {
		LinkedList<Integer> s2 = new LinkedList<Integer>();
		// Write your solution here.
		if (s1.size() <= 1) {
			return;
		}
		int count = 0;
		int size = s1.size();
		while (count < size) {
			int min = s1.peekFirst();
			while (!s1.isEmpty()) {
				int temp = s1.pollFirst();
				min = Math.min(min, temp);
				s2.offerFirst(temp);
			}
			int dupCount = 0;
			while (s2.size() > count) {
				int temp = s2.pollFirst();
				if (temp != min) {
					s1.offerFirst(temp);
				} else {
					dupCount++;
				}
			}
			for (int i = 0; i < dupCount; i++) {
				s2.offerFirst(min);
				count++;
			}
		}
		while (!s2.isEmpty()) {
			s1.offerFirst(s2.pollFirst());
		}
		return;
	}
}