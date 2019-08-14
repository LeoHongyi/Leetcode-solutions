// Q4 There are N pieces of wood, with their lengths (in meters) stored in Bords[N]. k painters are assigned to paint all these wood together.
// For each piece of wood, it can only be painted by 1 and only 1 painter, and each painter can only paint contiguous woods.
// Each painter can paint wood at the same speed, say 1 meter per minute.
// How can we find an assignments such that the total time for painting the wood is minimized.   
// return the minimum minutes to finish painting all the wood.
// e.g.
// k = 2
// woods[N] = {3, 6,  |  5, 5}
// return 10.
// {3 | 6,5,5}      16
// {3,6 |     5,5}  10
// {3,6,5 | 5}      14
                                      

// 左大段  +  右小段

// definition:
// dp[i][j] = i个工人paint前j个wood，minimum minutes to finish.
// induction rule:
// dp[i][j] =  min(max(dp[i-1][k],  subarray_sum[k+1, j])   for k 0 → j -1)
// base case
public int paint(int[] board, int k) {
	int length = board.length;
	int[][] dp = new int[k][length];
	for (int i = 0; i < length; i++) {
		dp[0][i] = sumHelper(board, 0, i);
}
for (int j = 0; j < k; j++) {
	dp[j][0] = board[0];
}
for (int i = 1; i < k; i++) {
	for (int j = 1; j < length; j++) {
		int best = dp[i - 1][j];
		for (int m = 0; m < j; m++) {
			best = Math.min(best, Math.max(dp[i - 1][m],sumHelper(board, m, j)));
}
dp[i][j] = best;
}
}
return dp[k - 1][length - 1];
}

private int sumHelper(int[] board, int l, int r) {
	int result = 0;
	for (int i = l; i <= r; i++) {
		result += board[i];
}
return result;
}
