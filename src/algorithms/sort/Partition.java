package algorithms.sort;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/549
 */
public class Partition {
    public void partition(int[] array, int pivotIndex) {
        int pivot = array[pivotIndex];
        swap(array, pivotIndex, array.length - 1);
        int left = 0;
        int right = array.length - 2;
        while(left <= right){
            if(array[left] <= pivot){
                left++;
            }else{
                swap(array, left, right);
                right--;
            }
        }
        swap(array, left, array.length - 1);
        return;
    }
    private void swap(int[] array, int a, int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}