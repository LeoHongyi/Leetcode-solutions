package algorithms.dynamicProgramming;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/160
 * Assumption: n >= 1
 *  Method: similar to Fibonacci, the last step can be 1 or 2,
 *  F(n) = F(n - 1) + F(n - 2)
 *  base case:  F(1) = 1, F(2) = 2,
 */

public class ClimbingStairs {
    public int stairs(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        int[] F = new int[n];
        F[0] = 1;
        F[1] = 2;
        for (int i = 2; i < n; i++) {
            F[i] = F[i - 1] + F[i - 2];
        }
        return F[n - 1];
    }
}
