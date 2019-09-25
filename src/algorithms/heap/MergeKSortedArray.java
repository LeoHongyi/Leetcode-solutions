package algorithms.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/133
 * Assumption: the input arrayOfArrays is not null, none of the arrays is null either
 *  Method: usd minHeap size k,
 *  k rows n col
 *  time O(knlogk), space O(k)
 */
public class MergeKSortedArray {
    public int[] merge(int[][] arrayOfArrays) {
        PriorityQueue<Tuple> minHeap = new PriorityQueue<>(11, new MyComparator());
        // rows of the arrays
        int length = 0;
        for (int i = 0; i < arrayOfArrays.length; i++) {
            int[] curArray = arrayOfArrays[i];
            length += curArray.length;
            if (curArray.length != 0) {
                minHeap.offer(new Tuple(i, 0, curArray[0]));
            }
        }
        int[] result= new int[length];
        int cur = 0;
        while (!minHeap.isEmpty()) {
            Tuple temp = minHeap.poll();
            result[cur++] = temp.value;
            if (temp.y + 1 < arrayOfArrays[temp.x].length) {
                temp.y++;
                temp.value = arrayOfArrays[temp.x][temp.y];
                minHeap.offer(temp);
            }
        }
        return result;
    }
    static class MyComparator implements Comparator<Tuple> {
        @Override
        public int compare(Tuple e1, Tuple e2) {
            if (e1.value < e2.value) {
                return -1;
            } else if (e1.value > e2.value) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
class Tuple {
    int x;
    int y;
    int value;
    Tuple(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }
}
