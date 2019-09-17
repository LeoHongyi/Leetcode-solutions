package BinarySearch;

public class SquareRootI {
    public int sqrt(int x) {
        // Write your solution here
        if (x == 0) {
            return  0;
        }
        int left = 0;
        int right = x / 2;
        int result = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid <= x / mid) {
                left = mid + 1;
                result = mid;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}
