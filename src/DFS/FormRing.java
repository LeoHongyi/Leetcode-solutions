package DFS;
/**
 * Given an array of strings, find if all the strings can be chained to form a circle. Two string s1 and s2 can be chained, iff the last letter of s1 is identical to the first letter of s2.
 *  For example,
 * “abc” and “cd” can be chained,
 * “abc” and “dz” can not be chained.
 *  Example Input:
 * arr[] = {"aaa", "bbb", "baa", "aab"};
 * Output: True,
 * The given input strings can be chained to form a circle. The strings can be chained as "aaa", "aab", "bbb" and "baa"
 * Method: DFS swap swap combinations
 * time : O(n!), space O(array.length())
 * **/
public class FormRing {
	public boolean formRing(String[] input) {
		if (input == null || input.length == 0) {
			return false;
		}
		// skip corner case
		return formRingDFS(input, 1);
	}
	private boolean formRingDFS(String[] input, int index) {
		// base case
		if (index == input.length) {
			return canConnect(input[index - 1], input[0]);
		}
		for (int i = index; i < input.length; i++) {
			if (canConnect(input[index - 1], input[i])) {
				swap(input, index, i);
				if (formRingDFS(input, index + 1)) {
					return true;
				}
				swap(input, index, i);
			}
		}
		return false;
	}
	private boolean canConnect(String a, String b) {
		if (a.charAt(a.length() - 1) == b.charAt(0)) {
			return true;
		}
		return false;

	}
	private void swap(String[] input, int index, int i) {
		String temp = input[index];
		input[index] = input[i];
		input[i] = temp;
	}
	public static void main(String args[]) {
		FormRing fr = new FormRing();
		String[] input1 = {"aaa", "bbb"};
		boolean result1 = fr.formRing(input1);
		System.out.println("input1: expected false, actual: " + result1);

		String[] input2 = {"aaa", "bbb", "baa", "aab"};
		boolean result2 = fr.formRing(input2);
		System.out.println("input2: expected true, actual: " + result2);

	}
}
