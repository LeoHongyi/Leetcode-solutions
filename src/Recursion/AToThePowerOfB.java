package Recursion;

public class AToThePowerOfB {
    public long power(int a, int b) {
        // Write your solution here
        if (b == 0 || a == 1) {
            return 1;
        } else if (a == 0) {
            return 0;
        }
        long half = power(a, b / 2);
        if (b % 2 == 0) {
            return half * half;
        } else {
            return half * half * a;
        }
    }
}

