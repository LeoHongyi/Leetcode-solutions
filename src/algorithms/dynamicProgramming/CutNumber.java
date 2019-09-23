package algorithms.dynamicProgramming;
/**
 * How to cut/split the number into a minimum number of items such that each item is equal to an integer's square value.
 * For example
 * 4 can be split to 1+1+1+1 (4 items) or 2^2 (1 item, which is the solution)
 * Return 1
 * 10 can be split to two items 3^2 + 1^2 (solution) or four items 2^2 + 2^2 + 1^2 +1^2
 * Return 2
 * Method: algorithms.dynamicProgramming
 * dp[i] represent the minimum number of perfect squares to sum up to i.
 * base case:
 * 	dp[0] = 0,
 * 	dp[1] = 1,
 * induction rule:
 * dp[i] = min(dp[i - j^2] + 1) where j >= 1 && j^2 <= i
 * **/
//SplitNumber
public class CutNumber {
	public int cutNumber(int input) {
		if (input < 1) {
			return 0;
		}
		int[] dp = new int[input + 1];
		dp[1] = 1;
		for (int i = 2; i < input + 1; i++) {
			dp[i] = i;
			for (int j = 1; j * j <= i; j++) {
				dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
			}
		}
		return dp[input];
	}
}


