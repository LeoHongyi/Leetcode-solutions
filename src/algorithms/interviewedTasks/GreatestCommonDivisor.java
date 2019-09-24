package algorithms.interviewedTasks;
// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED

// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
/**
 * time complexity: O(n^2), space: O(1)
 */
public class GreatestCommonDivisor {
    public int generalizedGCD(int num, int[] arr) {
        // WRITE YOUR CODE HERE
        if (arr == null || arr.length == 0) {
            return 0;
        }
        boolean unvalid = false;
        quickSort(arr, 0, arr.length - 1);
        int result = 1;
        for (int i = 1; i <= arr[0]; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] % i != 0) {
                    unvalid = true;
                    break;
                }
            }
            if (!unvalid) {
                result = Math.max(result, i);
            } else {
                unvalid = true;
            }
        }
        return result;
    }
    private void quickSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivotIndex = partition(array, start, end);
        quickSort(array, start, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, end);
    }
    private int partition(int[] array, int start, int end) {
        int pivotIndex = start + (int)Math.random() * (end - start + 1);
        int pivotValue = array[pivotIndex];
        swap(array, pivotIndex, end);
        int left = start;
        int right = end - 1;
        while (left <= right) {
            if (array[left] < pivotValue) {
                left++;
            } else if (array[right] > pivotValue) {
                right--;
            } else {
                swap(array, left, right);
                left++;
                right--;
            }
        }
        swap(array, left, end);
        return left;
    }
    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
    // METHOD SIGNATURE ENDS
}