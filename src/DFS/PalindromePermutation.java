package DFS;
/**
 Method: DFS, swap swap + check palindrome
 **/
public class PalindromePermutation {
	public boolean canPermutePalindrome(String input) {
		// Write your solution here
		char[] array = input.toCharArray();
		boolean[] result = new boolean[1];
		permutationDFS(array, 0, result);
		return result[0];
	}
	private void permutationDFS(char[] input, int index, boolean[] result) {
		if (index == input.length || result[0]) {
			if (isPalindrome(input)) {
				result[0] = true;
			}
			return;
		}
		for (int i = index; i < input.length; i++) {
			swap(input, index, i);
			permutationDFS(input, index + 1, result);
			swap(input, index, i);
		}
	}
	private boolean isPalindrome(char[] input) {
		int left = 0;
		int right = input.length - 1;
		while (left < right) {
			if (input[left] == input[right]) {
				left++;
				right--;
			} else {
				return false;
			}
		}
		return true;
	}
	private void swap(char[] input, int left, int right) {
		char temp = input[left];
		input[left] = input[right];
		input[right] = temp;
	}
}