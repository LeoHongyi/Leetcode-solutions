/**
  Assumptions: the given array is not null and has length of at least 2
**/
public class TwoSum {
  public boolean existSum(int[] array, int target) {
    // Write your solution here
    Set<Integer> set = new HashSet<>();
    for (int num : array) {
      if (set.contains(target - num)) {
        return true;
      }
      set.add(num);
    }
    return false;
  }
}


class Solution {
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