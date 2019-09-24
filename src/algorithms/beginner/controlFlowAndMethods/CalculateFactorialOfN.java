package algorithms.beginner.controlFlowAndMethods;

public class CalculateFactorialOfN {
    /**
     * @author Qihao He
     * @date 09/24/2019
     * https://app.laicode.io/app/problem/537
     */
    public int factorial(int n) {
        int sum = 1;
        while (n > 0){
            sum *= n;
            n--;
        }// Write your solution here
        return sum;
    }
}
