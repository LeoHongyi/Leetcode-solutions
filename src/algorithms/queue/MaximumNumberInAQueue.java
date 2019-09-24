package algorithms.queue;

public class MaximumNumberInAQueue {
    /**
     * @author Qihao He
     * @date 09/24/2019
     * https://app.laicode.io/app/problem/551
     */
    public int maxInQueue(Queue queue) {
        int max = queue.peek();
        while (!queue.isEmpty()) {
            Integer ele = queue.poll();
            if (ele.compareTo(max) > 0){
                max = ele;
            }
        }
        return max;
    }
}