package algorithms.recursion;

public class CalculateFactorialOfN {
    /**
     * @author Qihao He
     * @date 09/24/2019
     * https://app.laicode.io/app/problem/550
     */
    public long factorial(int n) {
        // Write your solution here
        long[] temp = new long[n + 1];
        temp[0] = 1;
        temp[1] = 1;
        for(int i = 2; i < n + 1; i++){
            temp[i] = temp[i - 1] * i;
        }
        return temp[n];
    }
}
