package BinarySearch;
//https://app.laicode.io/app/problem/161
public class SquareRootI {
    public int sqrt(int x) {
        // Write your solution here
        if (x == 0) {
            return  0;
        }
        int left = 1;
        int right = x;
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
