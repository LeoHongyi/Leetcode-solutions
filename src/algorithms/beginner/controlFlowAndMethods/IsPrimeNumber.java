package algorithms.beginner.controlFlowAndMethods;

public class IsPrimeNumber {
    /**
     * @author Qihao He
     * @date 09/24/2019
     * https://app.laicode.io/app/problem/535
     */
    public boolean isPrime(int n) {
        for (int i = 2; i <= n/2; i++) {
            if (n % i == 0) return false;
        }
        return true;// Write your solution here
    }
}
