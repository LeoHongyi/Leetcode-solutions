package algorithms.random;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianTracker {
    /**
     * @author Qihao He
     * @date 09/24/2019
     * https://app.laicode.io/app/problem/113
     */
    private PriorityQueue<Integer> smallerHalf;
    private PriorityQueue<Integer> largerHalf;
    public Solution() {
        // add new fields and complete the constructor if necessary.
        smallerHalf = new PriorityQueue<>(11, Collections.reverseOrder());
        largerHalf = new PriorityQueue<>();
    }

    public void read(int value) {
        // write your implementation here.
        // value maintain
        if (smallerHalf.isEmpty() || value <= smallerHalf.peek()) {
            smallerHalf.offer(value);
        } else {
            largerHalf.offer(value);
        }
        // size maintain
        if (smallerHalf.size() - largerHalf.size() >= 2) {
            largerHalf.offer(smallerHalf.poll());
        } else if (largerHalf.size() > smallerHalf.size()) {
            smallerHalf.offer(largerHalf.poll());
        }
    }

    public Double median() {
        // write your implementation here.
        int size = size();
        if (size == 0) {
            return null;
        } else if (size % 2 != 0) {
            return (double) (smallerHalf.peek());
        } else {
            return (smallerHalf.peek() + largerHalf.peek()) / 2.0;
        }
    }
    private int size() {
        return smallerHalf.size() + largerHalf.size();
    }
}
