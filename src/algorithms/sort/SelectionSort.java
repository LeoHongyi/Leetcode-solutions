package algorithms.sort;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/4
 * time: n * n = O(n^2)
 * space: O(1)
 */
public class SelectionSort {
    public int[] solve(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            swap(array, min, i);
        }
        return array;
    }
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
