package algorithms.dynamicProgramming;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/98
 * Method: DP, from left to right, linear scan
 * curMax[i] represent the max subarray product ending at i, curMin[i] is the min.
 * curMax[i] = Math.max(array[i], array[i] * curMax[i - 1], array[i] * curMin[i - 1])
 * curMin[i] = Math.min(array[i], array[i] * curMax[i - 1], array[i] * curMin[i - 1])
 * Assumption: the array is not null, length >= 1
 **/
public class LargestSubArrayProduct {


    public double largestProduct(double[] array) {
        // Write your solution here
        double curMin = array[0];
        double curMax = array[0];
        double result = curMax;
        for (int i = 1; i < array.length; i++) {
            double lastMin = curMin;
            double lastMax = curMax;
            curMin = Math.min(array[i], Math.min(array[i] * lastMax, array[i] * lastMin));
            curMax = Math.max(array[i], Math.max(array[i] * lastMax, array[i] * lastMin));
            result = Math.max(curMax, result);
        }
        return result;
    }
}
