package algorithms.beginner.primativeTypeAndBasicOperations;

public class AreRoughlyEqual {
    /**
     * @author Qihao He
     * @date 09/24/2019
     * https://app.laicode.io/app/problem/532
     */
    public boolean areEqual(double x, double y) {
        boolean b = Math.abs(x - y) <= 0.0001;//complete the expression
        return b;
        // Write your solution here
    }
}
