package algorithms.queue;

import java.util.Deque;

public class SumOfNumbersInAStack{
	public int sumOfStack(Deque<Integer> stack) {
		int sum = 0;
		while(stack.size() > 0){
			sum += stack.pollFirst();
		}
		return sum;
	}
}