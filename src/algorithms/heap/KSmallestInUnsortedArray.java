package algorithms.heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/25
 * Assumption: A is not null,
 *  Method: use maxHeap, maintain a k size maxheap
 *  time: O(klogk + (n-k)logk = nlogk), space: O(k)
 */
public class KSmallestInUnsortedArray {
    public int[] kSmallestMasxHeap(int[] array, int k) {
        // Write your solution here
        if (array.length == 0 || k == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());
        for (int i = 0; i < array.length; i++) {
            if (i < k) {
                maxHeap.offer(array[i]);
            } else {
                if (array[i] < maxHeap.peek()) {
                    maxHeap.poll();
                    maxHeap.offer(array[i]);
                }
            }
        }
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = maxHeap.poll();
        }
        return result;
    }
    public int[] kSmallestMinHeap(int[] array, int k) {
        // Write your solution here
        //minHeap
        //step 1: heapify the whole array
        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int a : array) {
            minHeap.offer(a);
        }
        int[] results = new int[k];
        //step 2: keep popping k times
        for (int i = 0; i < k; i++) {
            results[i] = minHeap.poll();
        }
        return results;
    }
}
