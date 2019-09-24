package algorithms.sort;

import java.util.Random;

public class BoundedRandomNumber {
    /**
     * @author Qihao He
     * @date 09/24/2019
     * https://app.laicode.io/app/problem/548
     */
    public int random(int a, int b) {
        Random rand = new Random();
        int randomValue = rand.nextInt(b - a + 1) + a;
        return randomValue;
    }
}

