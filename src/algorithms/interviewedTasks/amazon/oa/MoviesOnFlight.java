package algorithms.interviewedTasks.amazon.oa;
/**
 * https://leetcode.com/problems/two-sum/
 * My code passed only 10 test out of 13. I did a sorting and then found the best pair with 2 for loops
 *
 * Question:
 * You are on a flight and wanna watch two movies during this flight.
 * You are given List<Integer> movieDurations which includes all the movie durations.
 * You are also given the duration of the flight which is d in minutes.
 * Now, you need to pick two movies and the total duration of the two movies is less than or equal to (d - 30min).
 *
 * Find the pair of movies with the longest total duration and return they indexes. If multiple found,
 * return the pair with the longest movie.
 *
 * Example 1:
 *
 * Input: movieDurations = [90, 85, 75, 60, 120, 150, 125], d = 250
 * Output: [0, 6]
 * Explanation: movieDurations[0] + movieDurations[6] = 90 + 125 = 215 is the maximum number within 220 (250min - 30min)
 */
import java.util.ArrayList;
import java.util.Arrays;

public class MoviesOnFlight {
    /**
     * @author: Qihao He
     * @date: 09/27/2019
     * Assumption: nums can be null, or any length, may have duplicate length,
     * all movie in list are identical.
     * return only one pair when top 1s are tie.
     * Method: 2 sum with no sort, return indexes
     * time: O(n^2), space O(1)
     */
    public int[] pickMovie(int[] array, int d) {
        // sanity check
        int[] result = new int[2];
        if (array == null || array.length <= 2 || d <= 30) {
            return result;
        }
        int target = d - 30;
        int len = array.length;
        int max = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                int temp = array[i] + array[j];
                if (max < temp && temp <= target) {
                    max = temp;
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }


    /**
     * UNKNOWN author
     * My code passed only 10 test out of 13.
     * I did a sorting and then found the best pair with 2 for loops
     */
    public int[] pickMovie2(int[] nums, int d) {
        int[] result = new int[2];
        int max = Integer.MIN_VALUE;
        int start = 0;
        int end = nums.length - 1;
        Arrays.sort(nums);
        int i = 0;
        int j = 0;
        ArrayList<Integer> a = new ArrayList<Integer>();

        while (start <= end) {
            if ((nums[start] + nums[end]) <= d - 30) {
                if (max < (nums[start] + nums[end])) {
                    max = (nums[start] + nums[end]);
                    i = nums[start];
                    j = nums[end];
                }
                start++;
            } else if ((nums[start] + nums[end]) > d - 30) {
                end--;
            }
        }
        result[0] = i;
        result[1] = j;
// a.add(i);
// a.add(j);
// System.out.println(a);
        return result;
    }
}