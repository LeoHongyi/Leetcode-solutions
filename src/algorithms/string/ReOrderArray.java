package algorithms.string;

public class ReOrderArray {
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/197
 * Method: break the array into half,
 * and combine them using reverse.
 */
    public int[] reorder(int[] array) {
        // Write your solution here
        // Assumption: array is not null.
        if (array.length % 2 == 0) {
            reorder(array, 0, array.length - 1);
        } else {
            //if array has odd number of elements, we ignore the last one
            //when do the reordering.
            reorder(array, 0, array.length - 2);
        }
        return array;
    }
    private void reorder(int[] array, int left, int right) {
        int length = right - left + 1;
        //if the subarray has 2 or 0 elements, we can just return as this should be the base case.
        if (length <= 2) {
            return;
        }
        // Calculate the important mid points:
        //lm, m, rm, middle round to 0
        int mid = left + length / 2;
        int lmid = left + length / 4;
        int rmid = left + length * 3 / 4;
        reverse(array, lmid, mid - 1);
        reverse(array, mid, rmid - 1);
        reverse(array, lmid, rmid - 1);
        //half of the left partition's size = lmid - left.
        reorder(array, left, left + (lmid - left) * 2 - 1);
        reorder(array, left + (lmid - left) * 2, right);
    }
    private void reverse(int[] array, int left, int right) {
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }
}
