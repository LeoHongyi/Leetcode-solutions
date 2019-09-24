package algorithms.beginner.controlFlowAndMethods;

public class CalculateAtoThePowerOfB {
    /**
     * @author Qihao He
     * @date 09/24/2019
     * https://app.laicode.io/app/problem/538
     */
    public int power(int a, int b) {
        int sum = 1;
        for (; b >0; b--){
            sum *= a;
        }
        return sum;// Write your solution here
    }
}
