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
        LinkedList<Integer> s2 = new ArrayDeque<>();
        LinkedList<Integer> s3 = new ArrayDeque<>();
        if (s1.isEmpty()) {
            return null;
        }
        mergeSort(s1, s2, s3, s1.size());
    }
    private void mergeSort(LinkedList<Integer> s1,
                           LinkedList<Integer> s2, LinkedList<Integer> s3, int size) {
        int mid1 = size / 2;
        int mid2 = size - size / 2;
        for (int i = 0; i < mid1; i++) {
            s2.offerFirst(s1.pollFirst());
        }
        mergeSort(s1, s2, s3, mid2);
        mergeSort(s2, s1, s3, mid1);
        int i = 0;
        int j = 0;
        while (i < mid1 && j < mid2) {
            if (s1.peekFirst() <= s2.peekFirst()) {
                s3.offerFirst(s1.pollFirst());
                j++;
            } else {
                s3.offerFirst(s2.pollFirst());
                i++;
            }
        }
        while (i < mid1) {
            s3.offerFirst(s2.pollFirst());
            i++;
        }
        while(j < mid2) {
            s3.offerFirst(s1.pollFirst());
            j++;
        }
        int k = 0;
        while (k < size) {
            s1.offerFirst(s3.pollFirst());
        }
    }
}