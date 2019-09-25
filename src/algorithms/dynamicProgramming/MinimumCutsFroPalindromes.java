package algorithms.dynamicProgramming;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/143
 * Assumption: the given string is not null,
 *  Method: DP, isPalindrome() helper method.
 */
public class MinimumCutsFroPalindromes {
    public int minCuts(String input) {
        // Write your solution here
        if (input.length() == 0) {
            return 0;
        }
        int length = input.length();
        int[] dp = new int[length];
        dp[0] = 0;
        for (int i = 1; i < length; i++) {
            if (isPalindrome(input, 0, i)) {
                dp[i] = 0;
                continue;
            }
            dp[i] = i;
            for (int j = 1; j <= i; j++) {
                if (isPalindrome(input, j, i)) {
                    dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }
        return dp[length - 1];
    }
    private boolean isPalindrome(String input, int start, int end) {
        while (start < end) {
            if (input.charAt(start++) != input.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
