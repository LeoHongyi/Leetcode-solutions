package algorithms.hashTable;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/180
 * https://leetcode.com/problems/two-sum/
 * Assumptions: the given array is not null and has length of at least 2
 */
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoSum {
    public boolean existSum(int[] array, int target) {
        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            if (set.contains(target - num)) {
                return true;
            }
        set.add(num);
        }
        return false;
    }

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(target - nums[i]) != null) {
                return new int[] {map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);  
            } 
        }
        return new int[0];
    }
}