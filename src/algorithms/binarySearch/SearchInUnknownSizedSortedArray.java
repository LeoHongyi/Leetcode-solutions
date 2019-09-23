/*
*  interface Dictionary {
*    public Integer get(int index);
*  }
*/

// You do not need to implement the Dictionary interface.
// You can use it directly, the implementation is provided when testing your solution.
package algorithms.binarySearch;
//https://app.laicode.io/app/problem/20
public class SearchInUnknownSizedSortedArray {
  public int search(Dictionary dict, int target) {
    // Write your solution here
    if (dict.get(0) == null) {
      return -1;
    }
    int left = 0;
    int right = 1;
    while (dict.get(right) != null && dict.get(right) < target) {
      left = right;
      right = right * 2;
    }
    while (left < right - 1) {
      int mid = left + (right - left) / 2;
      if (dict.get(mid) == null) {
        right = mid;
      } else if (dict.get(mid) == target) {
        return mid;
      } else if (dict.get(mid) < target) {
        left = mid;
      } else {
        right = mid;
      }
    }
    if (dict.get(left) == target) {
      return left;
    } else if (dict.get(right) != null && dict.get(right) == target) {
      return right;
    } else {
      return -1;
    }
  }
}
