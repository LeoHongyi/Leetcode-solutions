package algorithms.binarySearch;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/19
 */
public class KClosestInSortedArray {
  public int[] kClosest(int[] array, int target, int k) {
    // Write your solution here
    if (array.length == 0) {
      return new int[0];
    }
    int left = 0;
    int right = array.length - 1;
    while (left < right - 1) {
      int mid = left + (right - left) / 2;
      if (array[mid] <= target) {
        left = mid;
      } else {
        right = mid;
      }
    }
    int[] results = new int[k];
    for (int i = 0; i < k; i++) {
      if (right >= array.length || left >= 0 && 
      Math.abs(array[left] - target) <  Math.abs(array[right] - target)) {
        results[i] = array[left];
        left--;
      } else {
        results[i] = array[right];
        right++;
      }
    }
    return results;
  }
}
