package algorithms.recursion;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/624
 */
public class FibonacciNumberLite {
    public int fibonacci(int K) {
        if (K < 0) {
            return 0;
        } else if (K == 0) {
            return 0;
        } else if (K == 1) {
            return 1;
        }
        int[] dp = new int[K + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < K + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[K];
    }
}
