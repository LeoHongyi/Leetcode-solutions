public class Solution {
  public int divide(int a, int b) {
    // Write your solution here
    if (b == 0) {
      return Integer.MAX_VALUE;
    } else if (a == 0) {
      return 0;
    }
    boolean neg = a * b < 0 ? true : false;
    int aAbs = Math.abs(a);
    int bAbs = Math.abs(b);
    int left = 0;
    int right = 1;
    while (left < right - 1) {
      int mid = left + (right - left) / 2;
      int midVal = bAbs * mid;
      if (midVal == aAbs) {
        return neg ? -mid : mid;
      } else if (midVal < aAbs) {
        left = mid;
      } else {
        right = mid;
      }
    }
    return neg ? -mid : mid;
  }
}
