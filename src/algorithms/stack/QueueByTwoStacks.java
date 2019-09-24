package algorithms.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueByTwoStacks {
    /**
     * @author Qihao He
     * @date 09/24/2019
     * https://app.laicode.io/app/problem/31
     */
    Deque<Integer> stackIn;
    Deque<Integer> stackOut;
    public QueueByTwoStacks() {
        // Write your solution here.
        stackIn = new ArrayDeque<>();
        stackOut = new ArrayDeque<>();
    }
    private void move() {
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.offerFirst(stackIn.pollFirst());
            }
        }
    }
    public Integer poll() {
        move();
        if (stackOut.isEmpty()) {
            return null;
        } else {
            return stackOut.pollFirst();
        }
    }

    public void offer(int element) {
        stackIn.offerFirst(element);
    }

    public Integer peek() {
        move();
        return stackOut.peekFirst();
    }

    public int size() {
        return stackIn.size() + stackOut.size();
    }

    public boolean isEmpty() {
        return stackIn.size() == 0 && stackOut.size() == 0;
    }
}
