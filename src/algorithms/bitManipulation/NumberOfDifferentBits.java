package algorithms.bitManipulation;

public class NumberOfDifferentBits {
    /**
     * @author Qihao He
     * @date 09/24/2019
     * https://app.laicode.io/app/problem/75
     */
    public int diffBits(int a, int b) {
        // Write your solution here
        a ^= b;
        int count = 0;
        while (a != 0) {
            count += a & 1;
            a = a >>> 1;
        }
        return count;
    }
}
