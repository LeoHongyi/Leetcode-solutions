package Algorithms.DynamicProgramming;
/**
 Method: Algorithms.DynamicProgramming
 dp[0] = 0,
 dp[1] = 1,
 dp[2] = 1,
 dp[3] = 2,
 ...
 dp[i] = dp[i - 1] + dp[i - 2]
 **/
//https://app.laicode.io/app/problem/624
public class Fibonacci {
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

    public int fibonacciRecursion(int K) {
        if (K == 0) {
            return 0;
        } else if (K == 1) {
            return 1;
        }
        return fibonacciRecursion(K - 1) + fibonacciRecursion(K - 2);
    }
}

