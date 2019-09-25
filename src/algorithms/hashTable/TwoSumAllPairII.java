package algorithms.hashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/182
 * Assumptions: the given array is not null and has length of at least 2
 *  the order of the values in th pair does not matter.
 *  Method: hash map
 */
public class TwoSumAllPairII {
    public List<List<Integer>> allPairs(int[] array, int target) {
        // Write your solution here
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : array) {
            Integer count = map.get(num);
            // case 1: x * 2 == target, second time seen
            if (num * 2 == target && count != null && count == 1) {
                result.add(Arrays.asList(num, num));
            } else if (map.containsKey(target - num) && count == null) {
                // case 2: x + y == target, and first time seen to deduplicate
                result.add(Arrays.asList(target - num, num));
            }
            // put num of array in map
            if (count == null) {
                map.put(num, 1);
            } else {
                map.put(num, count + 1);
            }
        }
        return result;
    }
}