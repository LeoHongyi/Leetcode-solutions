package algorithms.stack;

import java.util.Deque;

public class ShuffleStacks {
    /**
     * @author Qihao He
     * @date 09/24/2019
     * https://app.laicode.io/app/problem/553
     */
    public void shuffle(Deque<Integer> stack1, Deque<Integer> stack2) {
        while(!stack1.isEmpty()){
            stack2.offerFirst(stack1.pollFirst());
        }
    }
}