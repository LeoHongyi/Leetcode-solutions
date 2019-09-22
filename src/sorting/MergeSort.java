package sorting;

public class MergeSort {
    /**
     * @author: Qihao He
     * @date 06/20/2019
     * https://app.laicode.io/app/problem/9
     * Method: Merge sort
     * time: O(nlogn)
     * space heap: n, stack: nlogn
     */
    public int[] mergeSort(int[] array) {
        if (array == null || array.length == 0 || array.length == 1){
            //corner case
            return array;
        }
        // allocate helper array to help merge step
        int[] helper = new int[array.length];
        mergeSort(array, helper, 0, array.length - 1);
        return array;
    }

    private void mergeSort(int[] array, int[] helper, int left, int right){
        // array split in half the size arrays
        if (left >= right){
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(array, helper, left, mid);
        mergeSort(array, helper, mid + 1, right);
        merge(array, helper, left, mid, right);
    }

    private void merge(int[] array, int[] helper, int left, int mid, int right){
        // merge split arrays
        for (int i = left; i <= right; i++){
            helper[i] = array[i];
        }
        int leftIndex = left;
        int rightIndex = mid + 1;
        while (leftIndex <= mid && rightIndex <= right){
            if(helper[leftIndex] <= helper[rightIndex]){
                array[left++] = helper[leftIndex++];
            }else{
                array[left++] = helper[rightIndex++];
            }
        }
        while (leftIndex <= mid){
            // if we still have some elements at left side, we need to copy them
            array[left++] = helper[leftIndex++];
        }
    }

    /**
     * @author: Qihao He
     * @date 09/20/2019
     * https://app.laicode.io/app/problem/9
     * Method: Merge sort
     * time: O(nlogn)
     * space heap: n, stack: nlogn
     */
    public int[] mergeSort2(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        int[] helper = new int[array.length];
        mergeSort(array, helper, 0, array.length - 1);
        return array;
    }
    private void mergeSort2(int[] array, int[] helper, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort2(array, helper, start, mid);
        mergeSort2(array, helper, mid + 1, end);
        merge2(array, helper, start, mid, end);
    }
    private void merge2(int[] array, int[] helper, int start, int mid, int end) {
        for (int i = start; i < end; i++) {
            helper[i] = array[i];
        }
        int left = start;
        int right = mid + 1;
        while (left <= mid && right <= end) {
            if (helper[left] < helper[right]) {
                array[start] = helper[left];
                start++;
                left++;
            } else {
                array[start] = helper[right];
                start++;
                right++;
            }
        }
        while (left <= mid) {
            array[start] = helper[left];
            start++;
            left++;
        }
        return;
    }
    public static void main(String[] args) {
        int[] input = new int[] {5,6,3,12,1,8,2};
        int[] expect = new int[] {1,2,3,5,6,8,12};
        MergeSort sort = new MergeSort();
        sort.mergeSort2(input);
        for (int j = 0; j < expect.length; j++) {
            if (input[j] != expect[j]) {
                System.out.println("fail, not equal");
                return;
            }
        }
        System.out.println("success");
        return;
    }
}
