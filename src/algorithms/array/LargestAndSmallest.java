package algorithms.array;

public class LargestAndSmallest {
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/530
 * Method:
 *  step 1: split the numbers into winners and losers --- n / 2
 *  step 2: compute the min from the losers --- n / 2 - 1
 *  step 3: compute the max from the winners --- n / 2 - 1
 */
    public int[] largestAndSmallest(int[] array) {
        // Write your solution here
        int n = array.length;
        for (int i = 0; i < n / 2; i++) {
            // step 1, split winners and losers
            if (array[i] < array[n - 1 - i]) {
                // later part is the losers
                swap(array, i, n - 1 - i);
            }
        }
        return new int[] {largest(array, 0, (n - 1) / 2), smallest(array, n / 2, n - 1)};
    }
    // step 3, find the max of the winners
    private int largest(int[] array, int left, int right) {
        int largest = array[left];
        for (int i = left + 1; i <= right; i++) {
            largest = Math.max(largest, array[i]);
        }
        return largest;
    }
    // step 2, find the min of the losers
    private int smallest(int[] array, int left, int right) {
        int smallest = array[left];
        for (int i = left + 1; i <= right; i++) {
            smallest = Math.min(smallest, array[i]);
        }
        return smallest;
    }
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
