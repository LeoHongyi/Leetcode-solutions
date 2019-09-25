package algorithms.queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/204
 * Max Heap with lazy deletion
 *  simplified sliding window, Data structure: deque contains all elements
 *  in the sliding window but simplified.
 *  key insight: when a element is newer and bigger than other element,
 *  we can ignore the smaller one.
 *  Initialize:
 *  deque = the first k elements but simplified
 *  For each step:
 *  x = the new element
 *  while deque.right() <= x:
 *  deque.pop_right()
 *  deque.push_right(x)
 *  if deque.left() is out of the sliding window:
 *  deque.pop_left()
 *  Space: O(k)
 *  time: O(number of pop_right) <= O(number of pushes)
 *  <= O(n)
 */
public class MaximumValuesOfSizeKSlidingWindows {
    public List<Integer> maxWindows(int[] array, int k) {
        // Write your solution here
        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            while (!deque.isEmpty() && array[deque.peekFirst()] <= array[i]) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && deque.peekLast() <= i - k) {
                deque.pollLast();
            }
            deque.offerFirst(i);
            if (i >= k - 1) {
                result.add(array[deque.peekLast()]);
            }
        }
        return result;
    }
}
