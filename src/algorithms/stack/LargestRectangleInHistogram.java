package algorithms.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/198
 */
public class LargestRectangleInHistogram {
    public int largest(int[] array) {
        // Write your solution here
        Deque<Integer> stack = new ArrayDeque<>();
        int result = 0;
        for (int i = 0; i <= array.length; i++) {
            // we need a way of popping out all the elements in the stack
            // at last, so that we explicitly add a bar of height 0.
            int cur = i == array.length ? 0 : array[i];
            while (!stack.isEmpty() && array[stack.peekFirst()] >= cur) {
                int height = array[stack.pollFirst()];
                // determine the left boundary of the largest rectangle
                // with height array[i]
                int left = stack.isEmpty() ? 0 : stack.peekFirst() + 1;
                // determine the right boundary of the largest rectangle
                // with height of the popped element.
                result = Math.max(result, height * (i - left));
            }
            stack.offerFirst(i);
        }
        return result;
    }
}
