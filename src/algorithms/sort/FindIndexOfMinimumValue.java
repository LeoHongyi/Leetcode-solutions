package algorithms.sort;

public class FindIndexOfMinimumValue {
    /**
     * @author Qihao He
     * @date 09/24/2019
     * https://app.laicode.io/app/problem/546
     */
    public int minIndex(int[] array, int i) {
        // Write your solution here
        int minIndex = i;
        for (int j = i; j < array.length; j++){
            if(array[j] < array[minIndex]){
                minIndex = j;
            }
        }
        return minIndex;
    }
}
