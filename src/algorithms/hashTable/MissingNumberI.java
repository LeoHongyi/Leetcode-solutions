package algorithms.hashTable;

import java.util.HashSet;
import java.util.Set;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/68
 */
public class MissingNumberI {
    public int missing(int[] array) {
        // Write your solution here
        int n = array.length + 1;
        Set<Integer> hashSet = new HashSet<>();
        for (int i : array) {
            hashSet.add(i);
        }
        for (int i = 1; i <= array.length; i++) {
            if (!hashSet.contains(i)) {
                return i;
            }
        }
        return n;
    }
}

