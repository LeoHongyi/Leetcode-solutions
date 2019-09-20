package sorting;
import java.util.LinkedList;
/**
 * Method: use s2 as a buffer and a storage for global MIN,
 *  s1: used for storing all unsorted elements
 *  s2: left part | right part
 *  left part: to store all sorted elements in previous iterations
 *  right part: used as a buffer to find the current smallest element
 *  代码在具体的流程应该是
 *  1. 把s1中的所有m个元素倒到s2中，在这个过程中找到s1中的最小值
 *  2. 把s2中最上面的m个元素除了最小值之外再倒回s1
 *  3. 把最小值放到s2中
 *  4. 重复循环上面的1，2，3直到s1中元素为0
 */
public class SortWithTwoStacks {
	public void sort(LinkedList<Integer> s1) {
		LinkedList<Integer> s2 = new LinkedList<Integer>();
		// Write your solution here.
		if (s1.isEmpty()) {
			return;
		}
		// count the numbers that are sorted.
		int count = 0;
		int n = s1.size();
		while (count < n) {
			// reset min to MAX_VALUE
			int min = Integer.MAX_VALUE;
			// step 1: get s1 all elements into s2 and find min.
			while (s1.size() > 0) {
				min = Math.min(min, s1.peekFirst());
				s2.offerFirst(s1.pollFirst());
			}
			// step 2: get s2 to s1 (except the min)
			int duplicate = 0;
			while (s2.size() > count) {
				int temp = s2.pollFirst();
				if (temp != min) {
					s1.offerFirst(temp);
				} else {
					duplicate++;
				}
			}
			// step 3: offer min value into s2
			for (int i = 0; i < duplicate; i++) {
				s2.offerFirst(min);
				count++;
			}
		}
		while (!s2.isEmpty()) {
			s1.offerFirst(s2.pollFirst());
		}
	}
}