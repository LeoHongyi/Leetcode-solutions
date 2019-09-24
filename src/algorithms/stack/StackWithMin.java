package algorithms.stack;

import java.util.Deque;
import java.util.LinkedList;

public class StackWithMin {
    /**
     * @author Qihao He
     * @date 09/24/2019
     * https://app.laicode.io/app/problem/32
     */

    /**
     * time complexity: pop: O(1), push O(1), top O(1), min O(1)
     * space complexity: stack: worst case descending order: O(n), heap: O(1)
     * return special value "-1" when stack is empty
     **/
    Deque<Integer> stack;
    Deque<Pair<Integer, Integer>> minStack;
    public StackWithMin () {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    // Define Pair Class
    public class Pair<T extends Object, F extends Object> {
        public T key;
        public F value;
        public Pair(T key, F value) {
            this.key = key;
            this.value = value;
        }
        public T getKey() {
            return this.key;
        }
        public F getValue() {
            return this.value;
        }
        public void setValue(F value) {
            this.value = value;
        }
    }

    public int pop() {
        if (stack.isEmpty()) {
            return -1;
        }
        int num = stack.pop();
        if (stack.size() == minStack.peek().getValue()) {
            minStack.pop();
        }
        return num;
    }

    public void push(int element) {
        if (minStack.isEmpty() || element < minStack.peek().getKey()) {
            minStack.push(new Pair<>(element, stack.size()));
        }
        stack.push(element);
    }

    public int top() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peek();
    }

    public int min() {
        if (minStack.isEmpty()) {
            return -1;
        }
        return minStack.peek().getKey();
    }
}
