package sorting;

import java.util.ArrayDeque;
import java.util.LinkedList;

/**
 * https://app.laicode.io/app/problem/279
 * Method: merge sort with 3 stacks
 * time complexity: O(nlogn)
 * space complexity: stack: O(n), recursion O(1+2+...n/4+n/2+n) = O(2n-1)， heap: O(1), total O(n)
 **/
public class SortWith3Stacks {
    public void sort(LinkedList<Integer> s1) {
        LinkedList<Integer> s2 = new LinkedList<>();
        LinkedList<Integer> s3 = new LinkedList<>();
        // Write your solution here.
        sort(s1, s2, s3, s1.size());
    }
    private void sort(LinkedList<Integer> original, LinkedList<Integer> secondHalf,
                      LinkedList<Integer> helper, int originalSize) {
        if (originalSize <= 1) {
            return;
        }
        int secondHalfSize = originalSize / 2;
        int firstHalfSize = originalSize - originalSize / 2;
        for (int i = 0; i < secondHalfSize; i++) {
            secondHalf.offerFirst(original.pollFirst());
        }
        sort(original, secondHalf, helper, firstHalfSize);
        sort(secondHalf, original, helper, secondHalfSize);
        int i = firstHalfSize;
        int j = secondHalfSize;
        while (i > 0 || j > 0) {
            if (j <= 0 || i > 0 && original.peekFirst() <= secondHalf.peekFirst()) {
                helper.offerFirst(original.pollFirst());
                i--;
            } else {
                helper.offerFirst(secondHalf.pollFirst());
                j--;
            }
        }
        for (int k = 0; k < originalSize; k++) {
            original.offerFirst(helper.pollFirst());
        }
    }
}