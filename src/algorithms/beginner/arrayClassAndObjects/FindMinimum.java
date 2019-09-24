package algorithms.beginner.arrayClassAndObjects;

public class FindMinimum {
    /**
     * @author Qihao He
     * @date 09/24/2019
     * https://app.laicode.io/app/problem/539
     */
    public int min(int[] array) {
        if (array == null || array.length == 0){
            return 0;
        }
        if (array.length == 1){
            return array[0];
        }
        int s = array[0];
        for (int i = 1; i < array.length; i++){
            if (array[i] < s){
                s = array[i];
            }
        }// Write your solution here
        return s;
    }
}
