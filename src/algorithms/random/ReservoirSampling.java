package algorithms.random;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/109
 */
public class ReservoirSampling {
    /**
     * how many of numbers have been read so far.
     */
    private int count;
    /**
     * only need to maintain the current sample.
     */
    private Integer sample;
    public ReservoirSampling() {
        /**
         * Write your constructor code here if necessary.
         */
        this.count = 0;
        this.sample = null;
    }

    public void read(int value) {
        /**
         * Write your implementation here.
         */
        count++;
        int probable = (int) (Math.random() * count);
        /**
         * the current read value has the probability of
         * 1/count to be as the current sample.
         */
        if (probable == 0) {
            sample = value;
        }
    }

    public Integer sample() {
        /**
         * Write your implementation here.
         */
        return sample;
    }
}
