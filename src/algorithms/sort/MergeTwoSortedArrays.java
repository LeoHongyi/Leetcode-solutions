package algorithms.sort;

public class MergeTwoSortedArrays {
    /**
     * @author Qihao He
     * @date 09/24/2019
     * https://app.laicode.io/app/problem/547
     */
    public int[] merge(int[] one, int[] two) {
        // Write your solution here
        int[] three = new int[one.length + two.length];
        int oneCur = 0, twoCur = 0, threeCur = 0;
        while(oneCur < one.length && twoCur < two.length){
            if (one[oneCur] <= two[twoCur]){
                three[threeCur++] = one[oneCur++];
            } else {
                three[threeCur++] = two[twoCur++];
            }
        }
        //if array is not empty
        while(oneCur < one.length){
            three[threeCur++] = one[oneCur++];
        }
        while(twoCur < two.length){
            three[threeCur++] =  two[twoCur++];
        }
        return three;
    }
}
