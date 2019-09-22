package Algorithms.BinarySearch;
/**
 * https://leetcode.com/problems/first-bad-version/
 * The isBadVersion API is defined in the parent class VersionControl.
 * boolean isBadVersion(int version);
 */

public class FirstBadVersion {
    public int firstBadVersion(int n) {
        if (n == 0) {
            return 0;
        }
        int left = 0;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (isBadVersion(left)) {
            return left;
        } else if (isBadVersion(right)) {
            return right;
        } else {
            return -1;
        }
    }
}