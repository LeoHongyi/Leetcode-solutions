package algorithms.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/8
 * Method: recursion, stack
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        // Write your solution here
        // if (tokens == null || tokens.length == 0) {
        //     return 0;
        // } else if (tokens.length == 1) {
        //     return Integer.parseInt(tokens[0]);
        // }
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < tokens.length; i++) {
            switch (tokens[i]) {
                case "+":
                    stack.offerFirst(stack.pollFirst() + stack.pollFirst());
                    break;
                case "-":
                    stack.offerFirst(-stack.pollFirst() + stack.pollFirst());
                    break;
                case "*":
                    stack.offerFirst(stack.pollFirst() * stack.pollFirst());
                    break;
                case "/":
                    int n1 = stack.pollFirst(), n2 = stack.pollFirst();
                    stack.offerFirst(n2 / n1);
                    break;
                default:
                    stack.offerFirst(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pollFirst();
    }
}
