package algorithms.random;

import java.util.List;

public class Percentile95 {
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/114
 * key insight: max length of URLs <= 4096
 *  Data Structure:
 *  similar to bucket sort
 *  bucket[0] = the number of URLs of length 0
 *  bucket[1] = the number of URLs of length 1
 *  ...
 *  bucket[4096] = the number of URLs of length 4096
 *  Algorithm:
 *  step 1: for each url, insert them to buckets---O(n)
 *  step 2: find the minimum L such that sum(bucket[0...L] >= 0.95n --- O(4096) = O(1))
 */
    public int percentile95(List<Integer> lengths) {
        // Write your solution here.
        int[] count = new int[4097];
        for (int len : lengths) {
            // increment, bucket[current length] ++
            count[len]++;
        }
        int sum = 0;
        int len = 4097;
        while (sum <= 0.05 * lengths.size()) {
            sum += count[--len];
        }
        return len;
    }
}
