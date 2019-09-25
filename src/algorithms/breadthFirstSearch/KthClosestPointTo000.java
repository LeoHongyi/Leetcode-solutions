package algorithms.breadthFirstSearch;

import java.util.*;

/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/194
 * Method: best first search
 *  use minHeap, set for deduplicate
 */
public class KthClosestPointTo000 {
    public List<Integer> closest(int[] a, int[] b, int[] c, int k) {
        // Write your solution here
        PriorityQueue<Tuple> minHeap = new PriorityQueue<>(k, new Comparator<Tuple>() {
            @Override
            public int compare(Tuple o1, Tuple o2) {
                long o1Dis = getDis(o1, a, b, c);
                long o2Dis = getDis(o2, a, b, c);
                if (o1Dis < o2Dis) {
                    return -1;
                } else if (o1Dis > o2Dis) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        Tuple initial = new Tuple(0, 0, 0);
        minHeap.offer(initial);
        Set<Tuple> visited = new HashSet<>();
        visited.add(initial);
        while (k > 0) {
            Tuple cur = minHeap.poll();
            if (cur.ai + 1 < a.length && visited.add(new Tuple(cur.ai + 1, cur.bi, cur.ci))) {
                minHeap.offer(new Tuple(cur.ai + 1, cur.bi, cur.ci));
            }
            if (cur.bi + 1 < b.length && visited.add(new Tuple(cur.ai, cur.bi + 1, cur.ci))) {
                minHeap.offer(new Tuple(cur.ai, cur.bi + 1, cur.ci));
            }
            if (cur.ci + 1 < c.length && visited.add(new Tuple(cur.ai, cur.bi, cur.ci + 1))) {
                minHeap.offer(new Tuple(cur.ai, cur.bi, cur.ci + 1));
            }
            k--;
        }
        Tuple resultTuple = minHeap.peek();
        List<Integer> result = Arrays.asList(a[resultTuple.ai], b[resultTuple.bi], c[resultTuple.ci]);
        return result;
    }
    private long getDis(Tuple o1, int[] a, int[] b, int[] c) {
        long result = 0;
        result += (long) a[o1.ai] * a[o1.ai];
        result += b[o1.bi] * b[o1.bi];
        result += c[o1.ci] * c[o1.ci];
        return result;
    }
    class Tuple {
        int ai;
        int bi;
        int ci;
        public Tuple(int ai, int bi, int ci) {
            this.ai = ai;
            this.bi = bi;
            this.ci = ci;
        }
    }
}
