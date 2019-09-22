package Algorithms.Sort;

public class InsertionSort {
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
