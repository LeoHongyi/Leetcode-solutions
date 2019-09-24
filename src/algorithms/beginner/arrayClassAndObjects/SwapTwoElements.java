package algorithms.beginner.arrayClassAndObjects;

public class SwapTwoElements {
    /**
     * @author Qihao He
     * @date 09/24/2019
     * https://app.laicode.io/app/problem/541
     */
    public void swap(int[] array, int i, int j) {
        int temp = 0;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;// Write your solution here
    }
}
