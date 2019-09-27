package algorithms.design;
/**
 * @author Qihao He
 * @date 09/27/2019
 * https://leetcode.com/problems/design-hit-counter/
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
public class HitCounter {
    private final int fiveMinutes = 300;
    private int[] times;
    private int[] hits;
    public HitCounter() {
        times = new int[fiveMinutes];
        hits = new int[fiveMinutes];
    }

    /**
     * Record a hit.
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public void hit(int timestamp) {
        int index = timestamp % fiveMinutes;
        if (times[index] != timestamp) {
            times[index] = timestamp;
            hits[index] = 1;
        } else {
            hits[index]++;
        }
    }

    /**
     * Return the number of hits in the past 5 minutes.
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public int getHits(int timestamp) {
        int total = 0;
        for (int i = 0; i < fiveMinutes; i++) {
            if (timestamp - times[i] < fiveMinutes) {
                total += hits[i];
            }
        }
        return total;
    }
}
