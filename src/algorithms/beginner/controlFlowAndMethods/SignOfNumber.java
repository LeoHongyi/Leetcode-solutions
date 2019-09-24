package algorithms.beginner.controlFlowAndMethods;

public class SignOfNumber {
    /**
     * @author Qihao He
     * @date 09/24/2019
     * https://app.laicode.io/app/problem/534
     */
    public int sign(int x) {
        if (x == 0){
            return 0;
        } else if (x > 0) {
            return 1;
        } else
            return -1;// Write your solution here
    }
}
