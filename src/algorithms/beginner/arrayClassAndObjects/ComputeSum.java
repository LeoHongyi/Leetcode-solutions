package algorithms.beginner.arrayClassAndObjects;

public class ComputeSum {
    /**
     * @author Qihao He
     * @date 09/24/2019
     * https://app.laicode.io/app/problem/540
     */
    public int sum(int[] array) {
        if (array == null || array.length == 0){
            return 0;
        }
        int s = 0;
        for (int i = 0; i < array.length; i++){
            s += array[i];
        }
        return s;// Write your solution here
    }
}
