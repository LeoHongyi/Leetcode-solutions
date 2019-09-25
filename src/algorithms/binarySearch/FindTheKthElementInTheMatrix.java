package algorithms.binarySearch;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/561
 */
public class FindTheKthElementInTheMatrix {
    public int findElement(int[][] matrix, int k) {
        // Write your solution here
        //map the 1d index to 2d index
        int numOfCols = matrix[0].length;
        int row = k / numOfCols;
        int col = k % numOfCols;
        return matrix[row][col];
    }
}
