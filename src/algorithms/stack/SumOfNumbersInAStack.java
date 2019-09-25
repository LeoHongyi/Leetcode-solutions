package algorithms.stack;

import java.util.Deque;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/552
 */
public class SumOfNumbersInAStack {
    public int sumOfStack(Deque<Integer> stack) {
        int sum = 0;
        while(stack.size() > 0){
            sum += stack.pollFirst();
        }
        return sum;
    }
}