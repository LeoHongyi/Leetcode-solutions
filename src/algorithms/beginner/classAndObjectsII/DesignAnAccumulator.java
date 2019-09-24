package algorithms.beginner.classAndObjectsII;

public class DesignAnAccumulator {
}

/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/544
 */
class Accumulator {
    private int s = 0;
    public void add(int x) {
        s += x;
    }
    public int sum() {
        return s;
    }
}