package algorithms.greedy;

/**
 * @author: Qihao He
 * @date: 4/29/2019
 * https://app.laicode.io/app/problem/90
 * Method: DP, from right to left, return the left most result.
 * DP[0] = -1  if array[n - 1] == 0
 *       = 1  if array[n - 1] > 1
 * DP[i] represent the minimal jump from index i to out of the array.
 * DP[i] = 1  if array[i] + i >= n
 * = DP[j] + 1    if the min DP[j] >= 0, i < j <= array[i] + i
 * time: O(n^2)
 * space: O(n)
 * Assumption: array is not null, has length >= 1
 **/
public class ArrayHopperIII {
    public int minJump(int[] array) {
        // Write your solution here
        int n = array.length;
        int[] distance = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            // initialize as -1, unreachable.
            distance[i] = -1;
            if (array[i] + i >= n) {
                distance[i] = 1;
            } else {
                int curMin = -1;
                for (int j = i + array[i]; j >= i; j--) {
                    if (distance[j] >= 0) {
                        // min value when initialize as -1
                        curMin = (curMin < 0) ? (distance[j] + 1) : Math.min(distance[j] + 1, curMin);
                        // min value when initialize as -1
                        distance[i] = (distance[i] < 0) ? curMin : Math.min(curMin, distance[i]);
                    }
                }
            }
        }
        return distance[0];
    }
}
