package algorithms.heap;
/**
 * @author Qihao He
 * @date 09/24/2019
 * method: maxHeap,
 */
public class HeapSort {
    public int[] heapsort(int[] array) {
        heapSort(array);
        return array;
    }
    public void heapSort(int[] array) {
        if (array == null || array.length == 0) {
            //sanity check
            return;
        }
        // step 1 heapify
        heapify(array);
        for (int size = array.length; size > 1; size--) {
            // step 2
            // use the length of the heap to conduct the for loop.
            swap(array, 0, size - 1);
            percolateDown(array, 0, size - 1);
        }
    }
    private void heapify(int[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            percolateDown(array, i, array.length);
        }
    }

    private void percolateDown(int[] array, int index, int len) {
        while (index < len) {
            // using the first len elements as the heap, percolate down the element at index.
            // each time swap   index.
            int max = index;
            int left = index * 2 + 1;
            int right = index * 2 + 2;
            if (left < len && array[left] > array[max]) {
                // find the maximum one among cur, left child, right child.
                max = left;
            }
            if (right < len && array[right] > array[max]) {
                max = right;
            }

            if (max == index) {
                // check if it is cur itself.
                break;
            }
            swap(array, index, max);
            index = max;
        }
    }
    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}