package algorithms.heap;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author Qihao He
 * @date 09/28/2019
 * https://leetcode.com/problems/k-closest-points-to-origin/
 */
public class KClosestPointsToOrigin {
    /**
     * Assumption: input may be null, any length.
     *     there maybe duplicate elements,
     *     1. Method: min heap holds all points, pop k times
     *     2. Method: max Heap of size k, go through the all points
     */
    public int[][] kClosest(int[][] points, int K) {
        // sanity check
        if (points == null || points.length == 0 || points[0].length == 0)  {
            return new int[0][0];
        }
        PriorityQueue<Point> maxHeap = new PriorityQueue<>(K, new Comparator<Point>() {
            // max heap with comparator
            @Override
            public int compare(Point p1, Point p2) {
                long p1Dis = getDis(p1);
                long p2Dis = getDis(p2);
                if (p1Dis > p2Dis) {
                    return -1;
                } else if (p1Dis < p2Dis){
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        for (int i = 0; i < K; i++) {
            // fill first K points into the Max heap
            maxHeap.offer(new Point(points[i][0], points[i][1]));
        }
        for (int i = K; i < points.length; i++) {
            Point temp = new Point(points[i][0], points[i][1]);
            long tempDis = getDis(temp);
            Point curMax = maxHeap.peek();
            long curMaxDis = getDis(curMax);
            if (curMaxDis > tempDis) {
                maxHeap.poll();
                maxHeap.offer(temp);
            }
        }
        int[][] result = new int[K][2];
        for (int i = 0; i < K; i++) {
            Point temp = maxHeap.poll();
            result[i][0] = temp.x;
            result[i][1] = temp.y;
        }
        return result;
    }

    private long getDis(Point p) {
        long result = 0;
        result += (long) p.x * p.x;
        result += p.y * p.y;
        return result;
    }

    class Point{
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
