package String;

public class ValidPalindromeII {
    public boolean validPalindrome(String input) {
        // Write your solution here
        if (input == null || input.length() <= 1) {
            return true;
        }
        int left = 0;
        int right = input.length() - 1;
        int count = 1;
        while (left < right) {
            if (input.charAt(left) == input.charAt(right)) {
                left++;
                right--;
                continue;
            } else if (left + 1 < right && count != 0 &&
                    input.charAt(left + 1) == input.charAt(right)) {
                left = left + 2;
                right--;
                count--;
                continue;
            } else if (left < right - 1 && count != 0 &&
                    input.charAt(left) == input.charAt(right - 1)) {
                right = right - 2;
                left++;
                count--;
                continue;
            } else return left + 1 == right;
        }
        return true;
    }
}
