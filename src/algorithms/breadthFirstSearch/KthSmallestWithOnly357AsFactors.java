package algorithms.breadthFirstSearch;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/193
 * Assumption: k >= 1
 *  Method: Best first Search
 *  1. initial state: <x=1, y=1, z=1>
 *  2. expand/generate rule:
 *  a. expand<x, y, z> // 3^x * 5^y * 7^z
 *  b. generate <x+1, y, z>, <x, y+1, z>, <x, y, z+1>
 *  3. termination conditon: when the kth element is popped out from the PQ
 *  4. deduplication: must deduplicate
 *  time = O(klogk)
 */
public class KthSmallestWithOnly357AsFactors {
    public long kth(int k) {
        // Write your solution here
        PriorityQueue<Long> minHeap = new PriorityQueue<>(k);
        // set visited for deduplication
        Set<Long> visited = new HashSet<>();
        // we use the actual product value to represent the states
        // <x,y,z>, the value if 3^x*5^y*7^z, and the initial state is <1,1,1>.
        minHeap.offer(3 * 5 * 7L);
        visited.add(3 * 5 * 7L);
        while (k > 1) {
            long current = minHeap.poll();
            // for the state <x + 1, y, z>, the actual value is *3.
            if (visited.add(3 * current)) {
                minHeap.offer(3 * current);
            }
            // for the state <x, y + 1, z>, the actual value is *5
            if (visited.add(5 * current)) {
                minHeap.offer(5 * current);
            }
            // for the state <x, y, z + 1>, the actual value is *7
            if (visited.add(7 * current)) {
                minHeap.offer(7 * current);
            }
            k--;
        }
        return minHeap.peek();
    }
}
