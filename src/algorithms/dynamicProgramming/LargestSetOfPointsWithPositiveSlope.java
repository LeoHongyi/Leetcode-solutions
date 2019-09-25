package algorithms.dynamicProgramming;
import java.util.Arrays;
import java.util.Comparator;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/217
 * Method: algorithms.dynamicProgramming, similar to Longest ascending sub-sequence
 *  dp[i] represent the longest ascending sub-sequence ends at a[i]
 *  dp[0] =
 *  slope = (y2 - y1) / (x2 - x1) > 0
 *  Step 1. sort the input points according to their x-coordinates, results is put in A[n]
 *  Time: O(nlogn)
 *  step 2. A[n] = {<x0,y0>,<x1,y1>,<x2,y2>,<x3,y3>... <xn,yn>}
 *  Find the longest ascending sub-sequence in A[n] according to their y-coordinates.
 *  Time: O(nlogn)
 */
class Point {
	public int x;
	public int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class LargestSetOfPointsWithPositiveSlope {
	public int largest(Point[] points) {
		// Write your solution here.
		Arrays.sort(points, new MyComparator());
		int n = points.length;
		int result = 0;
		int[] DP = new int[n];
		for (int i = 0; i < n; i++) {
			DP[i] = 1;
			for (int j = 0; j < i; j++) {
				if (points[j].y < points[i].y) {
					DP[i] = Math.max(DP[i], DP[j] + 1);
				}
			}
			result = Math.max(result, DP[i]);
		}
		return result == 1 ? 0 : result;
	}
	// This comparator will sort the points by y first then by x
	// yBigger <- ySmaller, xSmaller <- xBigger
	static class MyComparator implements Comparator<Point> {
		@Override
		public int compare(Point p1, Point p2) {
			if (p1.x < p2.x) {
				return -1;
			} else if (p1.x > p2.x) {
				return 1;
			} else if (p1.y > p2.y) {
				return -1;
			} else if (p1.y < p2.y) {
				return 1;
			} else {
				return 0;
			}
		}
	}
}
