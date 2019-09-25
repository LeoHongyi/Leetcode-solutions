package algorithms.sort;

import java.util.Arrays;
/**
 * @author: Qihao He
 * @date 06/23/2019
 * https://app.laicode.io/app/problem/261
 * Method: Rainbow sort
 * worst: time: O(n^2), space O(n)
 * average: time: O(n^2), space O(logn)
 */
public class SortInSpecifiedOrder {
    public int[] sortSpecial(int[] A1, int[] A2) {
        Arrays.sort(A1);
        int slow = 0;
        int i = 0;
        while (slow < A1.length && i < A2.length) {
            int target = A2[i];
            int fast = slow;
            while (fast < A1.length) {
                if (A1[fast] == target) {
                    swap(A1, fast, slow);
                    fast++;
                    slow++;
                } else {
                    fast++;
                }
            }
            i++;
        }
        return A1;
    }
    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
