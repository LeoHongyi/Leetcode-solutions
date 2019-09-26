package algorithms.dynamicProgramming;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/216
 * Method: HashMap,
 *  HashMap<key = <k, b>, Value = Set of points>
 */

import algorithms.graph.Point;

import java.util.HashMap;
import java.util.Map;

/**
 * class Point {
 *   public int x;
 *   public int y;
 *   public Point(int x, int y) {
 *     this.x = x;
 *     this.y = y;
 *   }
 * }
 */
public class MostPointsOnALine {
    public int most(Point[] points) {
        // Write your solution here.
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            int same = 1;
            int sameX = 0;
            int max = 0;
            Map<Double, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    same++;
                } else if (points[i].x == points[j].x) {
                    sameX++;
                } else {
                    double slope = (points[j].y - points[i].y + 0.0) / (points[j].x - points[i].x);
                    if (!map.containsKey(slope)) {
                        map.put(slope, 1);
                    } else {
                        map.put(slope, map.get(slope) + 1);
                    }
                    max = Math.max(map.get(slope), max);
                }
            }
            max = Math.max(sameX, max) + same;
            result = Math.max(max, result);
        }
        return result;
    }
}
