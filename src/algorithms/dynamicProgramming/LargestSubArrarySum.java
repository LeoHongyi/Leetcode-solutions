package algorithms.dynamicProgramming;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/489
 * Method: DP from left to right linear scan.
 *  curMax[i] represent the max subArray sum inluding the array[i]
 *  curMax[0] = array[0]
 *  curMax[i] = max(array[i], curMax[i - 1] + array[i])
 *  curMax[i] = array[i]    if curMax[i - 1] < 0
 *  =  curMax[i - 1] + array[i]    if curMax[i - 1] >= 0
 *  update gloMax when curMax > gloMax
 *  time O(n), space O(1)
 */
public class LargestSubArrarySum {
    public int[] largestSum(int[] array) {
        // Write your solution here
        if (array.length == 1) {
            return new int[]{array[0], 0, 0};
        }
        int n = array.length;
        int curStart = 0;
        int gloStart = 0;
        int gloEnd = 0;
        int curMax = array[0];
        int gloMax = array[0];
        for (int i = 1; i < n; i++) {
            if (array[i] < curMax + array[i]) {
                curMax = curMax + array[i];
            } else {
                // array[i] >= curMax + array[i]
                curMax = array[i];
                curStart = i;
            }
            if (curMax > gloMax) {
                gloMax = curMax;
                gloStart = curStart;
                gloEnd = i;
            }
        }
        return new int[]{gloMax, gloStart, gloEnd};
    }
}
