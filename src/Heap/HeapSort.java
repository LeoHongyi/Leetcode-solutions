package Heap;

//method: maxHeap,
public class HeapSort {
    public int[] heapsort(int[] array) {
        // Write your solution here
        heapSort(array);
        return array;
    }
    public void heapSort(int[] array) {
        //sanity check
        if (array == null || array.length == 0) return;
        // step 1 heapify
        heapify(array);
        // step 2
        // use the length of the heap to conduct the for loop.
        for (int size = array.length; size > 1; size--) {
            swap(array, 0, size - 1);
            percolateDown(array, 0, size - 1);
        }
    }
    private void heapify(int[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            percolateDown(array, i, array.length);
        }
    }
    // using the first len elements as the heap, percolate down the element at index.
    private void percolateDown(int[] array, int index, int len) {
        while (index < len) {  // each time swap   index.
            int max = index;
            int left = index * 2 + 1;
            int right = index * 2 + 2;
            // find the maximum one among cur, left child, right child.
            if (left < len && array[left] > array[max]) {
                max = left;
            }
            if (right < len && array[right] > array[max]) {
                max = right;
            }
            // check if it is cur itself.
            if (max == index) {
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