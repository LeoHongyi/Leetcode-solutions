package algorithms.recursion;
/**
 * https://app.laicode.io/app/problem/13
 * recursion tree: height: logb, branch: 1
 * time: O(logb)
 * space: O(logb)
 */
public class AToThePowerOfB {
    public long power(int a, int b) {
        if (b == 0) {
            return 1;
        } else if (a == 0) {
            return 0;
        } else if (a == 1) {
            return 1;
        }
        long half = power(a, b / 2);
        if (b % 2 != 0) {
            return a * half * half;
        } else {
            return half * half;
        }
    }
}

