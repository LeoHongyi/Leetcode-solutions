package Algorithms.Sort;

public class InsertionSort {
    /**
     * @author Qihao He
     * @date 09/22/2019
     * https://app.laicode.io/app/problem/340
     * Method: insertion sort
     * time: O(n^2), space: O(1)
     */
    public int[] sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int curValue = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > curValue) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = curValue;
        }
        return array;
    }
}
