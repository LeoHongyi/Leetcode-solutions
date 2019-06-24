package String;

public class ValidPalindrome {
    public boolean valid(String input) {
        // Write your solution here
        // sanity check
        if (input == null || input.length() <= 1) {
            return true;
        }
        int left = 0;
        int right = input.length() - 1;
        while (left < right) {
            while (left < right && !isAlpha(input.charAt(left))) {
                left++;
            }
            while (left < right && !isAlpha(input.charAt(right))) {
                right--;
            }
            if (input.charAt(left++) != input.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
    private boolean isAlpha(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        } else if (c >= 'A' && c <= 'Z') {
            return true;
        } else if (c >= 'a' && c <= 'z') {
            return true;
        } else {
            return false;
        }
    }
}
