package BinarySearch;
/**
 * https://leetcode.com/problems/divide-two-integers/
 * https://app.laicode.io/app/problem/321
 * time: O(logn)
 * space O(1)
 */
public class DivideTwoIntegersWithRestrictions {
  public int divide(int a, int b) {
      if (b == 0) {
        return Integer.MAX_VALUE;
      } else if (a == 0) {
        return 0;
      }
      boolean neg = a * b < 0;
      int aAbs = Math.abs(a);
      int bAbs = Math.abs(b);
      int left = 0;
      int right = 1;
      while (bAbs * right <= aAbs) {
        left = right;
        right = right * 2;
      }
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
      if (neg) {
          if (-left > Integer.MAX_VALUE) {
              return Integer.MAX_VALUE;
          } else {
              return -left;
          }
      } else {
          return left;
      }
    }
  }
