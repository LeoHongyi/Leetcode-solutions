package BinarySearch;
//https://app.laicode.io/app/problem/636
public class SmallestElementLargerThanTarget {
  public int largerThanTarget(int[] array, int target) {
    if (array == null || array.length == 0) {
      return -1;
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
    if (array[left] > target) {
      return left;
    } else if (array[right] > target) {
      return right;
    }
    return -1;
  }
}
