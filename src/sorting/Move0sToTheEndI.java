package sorting;

public class Move0sToTheEndI {
    /**
     * @author: Qihao He
     * @date 06/21/2019
     * https://app.laicode.io/app/problem/258
     * Method: rainbow sort
     * time: O(n)
     * space O(1)
     */
    public int[] moveZero(int[] array) {
        // Write your solution here
        if (array == null || array.length <= 1) {
            return array;
        }
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            if (array[left] != 0) {
                left++;
            } else if (array[right] == 0) {
                right--;
            } else {
                swap(array, left, right);
                left++;
                right--;
            }
        }
        return array;
    }
    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
        return;
    }
}

