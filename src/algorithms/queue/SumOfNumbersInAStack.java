package algorithms.queue;

public class SumOfNumbersInAStack


class Solution {
	public int sumOfStack(Deque<Integer> stack) {
		int sum = 0;
		while(stack.size() > 0){
			sum += stack.pollFirst();
		}
		return sum;
	}
}