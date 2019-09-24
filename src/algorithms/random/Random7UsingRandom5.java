package algorithms.random;

public class Random7UsingRandom5 {
    /**
     * @author Qihao He
     * @date 09/24/2019
     * https://app.laicode.io/app/problem/111
     */
    public int random7() {
        // write your solution here
        // you can use RandomFive.random5() for generating
        // 0 - 4 with equal probability.
        while (true) {
            int random25 = 5 * RandomFive.random5() + RandomFive.random5();
            if (random25 < 21) {
                return random25 % 7;
            }
        }
    }
}
