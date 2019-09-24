package algorithms.random;

public class Random100UsingRandom5 {
    /**
     * @author Qihao He
     * @date 09/24/2019
     * https://app.laicode.io/app/problem/112
     */
    public int random1000() {
        // Write your solution here.
        // you can use RandomFive.random5() for generating
        // 0 - 4 with equal probability.
        while (true) {
            // 5^5 = 3125
            int randomNum = 0;
            for (int i = 0; i < 5; i++) {
                randomNum = randomNum * 5 + RandomFive.random5();
            }
            // choose 3000 out of 3125
            if (randomNum < 3000) {
                return randomNum % 1000;
            }
        }
    }
}
