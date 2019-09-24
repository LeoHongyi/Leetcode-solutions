package algorithms.beginner.controlFlowAndMethods;

public class CalculateSumOfSquares {
    /**
     * @author Qihao He
     * @date 09/24/2019
     * https://app.laicode.io/app/problem/536
     */
    public int sumOfSquares(int n) {
        int j = (int) Math.sqrt(n);
        int sum = 0;
        for (int i = 1; i <= j; i++) {
            sum += i * i;
        }
        return sum;
        // Write your solution here
    }
}
