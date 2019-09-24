package algorithms.beginner.arrayClassAndObjects;

public class SumOf2DArray {
    /**
     * @author Qihao He
     * @date 09/24/2019
     * https://app.laicode.io/app/problem/543
     */
    public int sum(int[][] array) {
        int sum = 0;
        for (int row = 0; row < array.length; row++){
            for (int col = 0; col < array[0].length; col++){
                sum += array[row][col];
            }
        }
        return sum;// Write your solution here
    }
}
