package algorithms.twoPointers;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/171
 * Assumption: the 3 given sorted arrays are not null,
 *  There could be duplicate elements in each of the arrays.
 *  Method: 3 pointers.
 */
public class CommonElementsInThreeSortedArray {
    public List<Integer> common(int[] a, int[] b, int[] c) {
        // Write your solution here
        List<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        int k = 0;
        // if i, j, k any pointer reaches the end, common letters are done
        while (i < a.length && j < b.length && k < c.length) {
            if (a[i] == b[j] && b[j] == c[k]) {
                result.add(a[i]);
                i++;
                j++;
                k++;
            } else if (a[i] <= b[j] && a[i] <= c[k]) {
                i++;
            } else if (b[j] <= a[i] && b[j] <= c[k]) {
                j++;
            } else {
                k++;
            }
        }
        return result;
    }
}
