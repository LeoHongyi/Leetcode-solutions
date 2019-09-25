package algorithms.random;

import java.util.ArrayList;
import java.util.List;

public class GeneralizedReservoirSampling {
    /**
     * @author Qihao He
     * @date 09/24/2019
     * https://app.laicode.io/app/problem/110
     */
    private final int k;
    private int count;
    private List<Integer> sample;

    public GeneralizedReservoirSampling(int k) {
        // Complete the constructor if necessary.
        if (k <= 0) {
            throw new IllegalArgumentException("k must be > 0");
        }
        this.k = k;
        this.count = 0;
        sample = new ArrayList<Integer>();
    }

    public void read(int value) {
        // Write your implementation here.
        count++;
        if (count <= k) {
            // first k elements, add to sample list
            sample.add(value);
        } else {
            int randomIndex = (int) (Math.random() * count);
            // for the new read element, it has the probability of
            // k/count to be the  as one of the sample.
            if (randomIndex < k) {
                sample.set(randomIndex, value);
            }
        }
    }

    public List<Integer> sample() {
        // Write your implementation here.
        return sample;
    }
}
