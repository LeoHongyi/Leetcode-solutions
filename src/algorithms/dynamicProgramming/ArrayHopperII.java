package algorithms.dynamicProgramming;

public class ArrayHopperII {
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/89
 * Method: DP, from right to left
 *  dp[i] represent the minimum steps to reach to the end.
 */
public class Solution {
    public int minJump(int[] array) {
        // Write your solution here
        if (array.length == 1) {
            return 0;
        }
        int length = array.length;
        int[] minJump = new int[length];
        minJump[length - 1] = 0;
        for (int i = length - 2; i >= 0; i--) {
            // initialize as unreachable.
            minJump[i] = -1;
            if (array[i] + i >= length - 1) {
                minJump[i] = 1;
            } else {
                // search i right side for stepStone j
                for (int j = array[i] + i; j >= i; j--) {
                    // valid stepStone minJump[j]
                    if (minJump[j] != -1) {
                        // update minJump[i] when first meet or find a smaller value
                        if (minJump[i] == -1 || minJump[j] + 1 < minJump[i]) {
                            minJump[i] = minJump[j] + 1;
                        }
                    }
                }
            }
        }
        return minJump[0];
    }
}
