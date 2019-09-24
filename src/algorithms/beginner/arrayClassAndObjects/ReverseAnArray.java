package algorithms.beginner.arrayClassAndObjects;

public class ReverseAnArray {
    /**
     * @author Qihao He
     * @date 09/24/2019
     * https://app.laicode.io/app/problem/542
     */
    public void reverse(int[] array) {
        if (array.length == 0){
            return;
        }
        int buff;
        int left = 0;
        int right = array.length - 1;
        while (left <= right - 1){
            buff = array[left];
            array[left] = array[right];
            array[right] = buff;
            left++;
            right--;
        }
        // Write your solution here
    }
}
