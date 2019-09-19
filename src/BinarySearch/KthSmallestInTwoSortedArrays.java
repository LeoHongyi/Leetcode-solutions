package BinarySearch;

public class KthSmallestInTwoSortedArrays {
  public int kth(int[] a, int[] b, int k) {
    // Write your solution here
    int aleft = 0;
    int bleft = 0;
    return kthHelper(a, aleft, b, bleft, k);  
  }

  private int kthHelper(int[] a, int aleft, int[] b, int bleft, int k) {
    // base case
    if (aleft >= a.length) {
      return b[bleft + k - 1];
    }
    if (bleft >= b.length) {
      return a[aleft + k - 1];
    }
    if (k == 1) {
      return Math.min(a[aleft], b[bleft]);
    }
    // Since the index start from left,
    int amid = aleft + k / 2 - 1;
    int bmid = bleft + k / 2 - 1;
    // if a.size is too small, then remove elements from b list.
    int aval = amid >= a.length ? Integer.MAX_VALUE : a[amid];
    int bval = bmid >= b.length ? Integer.MAX_VALUE : b[bmid];

    if (aval <= bval) {
      return kthHelper(a, amid + 1, b, bleft, k - k / 2);
    } else {
      return kthHelper(a, aleft, b, bmid + 1, k - k / 2);
    }
  }
}
