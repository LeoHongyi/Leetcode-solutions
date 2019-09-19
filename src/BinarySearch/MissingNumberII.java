package BinarySearch;

public class MissingNumberII {
    public int missing(int[] array) {
        // Write your solution here
        int i = 1;
        for (; i < array.length + 1; i++) {
            if (i != array[i - 1]) {
                return i;
            }
        }
        return i;
    }

    public int binarySearchMissing(int[] array) {
        // Write your solution here
        if (array.length == 0) {
            return 1;
        }
        int left = 0;
        int right = array.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] == mid + 1 && array[mid + 1] == mid + 3)  {
                return mid + 2;
            } else if (array[mid] == mid + 2 && array[mid + 1] == mid + 3) {
                right = mid;
            } else if (array[mid] == mid + 1 && array[mid + 1] == mid + 2){
                left = mid + 1;
            }
        }
        return right + 1;
    }
}
