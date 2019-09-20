package sorting;

import java.util.ArrayDeque;
import java.util.LinkedList;


public class SortWithThreeStacks {
    /**
     * https://app.laicode.io/app/problem/279
     * Method: merge sort with 3 stacks
     * time complexity: O(nlogn)
     * space complexity: stack: O(n), recursion O(1+2+...n/4+n/2+n) = O(2n-1)， heap: O(1), total O(n)
     **/
    public void mergeSortWithThreeStacks(LinkedList<Integer> s1) {
        LinkedList<Integer> s2 = new LinkedList<>();
        LinkedList<Integer> s3 = new LinkedList<>();
        // Write your solution here.
        mergeSort(s1, s2, s3, s1.size());
    }
    private void mergeSort(LinkedList<Integer> original, LinkedList<Integer> secondHalf,
                      LinkedList<Integer> helper, int originalSize) {
        if (originalSize <= 1) {
            return;
        }
        int secondHalfSize = originalSize / 2;
        int firstHalfSize = originalSize - originalSize / 2;
        for (int i = 0; i < secondHalfSize; i++) {
            secondHalf.offerFirst(original.pollFirst());
        }
        mergeSort(original, secondHalf, helper, firstHalfSize);
        mergeSort(secondHalf, original, helper, secondHalfSize);
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

    /**
     * https://app.laicode.io/app/problem/279
     * Method: selection sort with 3 stacks
     * time complexity: O(n^2)
     * space complexity: stack: O(3n)
     **/
    public void selectionSortWithThreeStacks(LinkedList<Integer> s1) {
        LinkedList<Integer> s2 = new LinkedList<>();
        LinkedList<Integer> s3 = new LinkedList<>();
        if (s1.size() <= 1) {
            return;
        }
        while (!s1.isEmpty()) {
            int min = s1.peekFirst();
            while (!s1.isEmpty()) {
                int temp = s1.pollFirst();
                if (temp < min) {
                    min = temp;
                }
                s2.offerFirst(temp);
            }
            s3.offerFirst(min);
            while (!s2.isEmpty()) {
                int temp = s2.pollFirst();
                if (temp > s3.peekFirst()) {
                    s1.offerFirst(temp);
                }
            }
        }
        while(!s3.isEmpty()) {
            s1.offer(s3.pollFirst());
        }
        return;
    }
}
