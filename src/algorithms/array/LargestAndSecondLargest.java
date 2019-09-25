package algorithms.array;

import java.util.ArrayList;
import java.util.List;

public class LargestAndSecondLargest {
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/120
 * Method: similar to mergeSort
 *  1st largest = n
 *  2nd largest = log(n)
 *  total # of comparisons = n + log(n)
 *  compare each of the pairs,
 *  for each comparison, store the loser into the winner array.
 *  Assumption:  array is not null, array.length >= 2
 */
/**

 **/
    // The Element class will be used to store the original value
    // in the array and all the values compared to it.
    static class Element {
        int value;
        List<Integer> compredValues;
        Element(int value) {
            this.value = value;
            this.compredValues = new ArrayList<>();
        }
    }
    public int[] largestAndSecond(int[] array) {
        // Write your solution here
        // Convert the original array to Element array.
        Element[] helper = convert(array);
        // largerLength is the left partition's length containing the
        // larger values after each round of comparison.
        // For each round, the comparison is still doint for each of
        // the indices pairs (i, largerLength - 1 - i).
        // So that the larger elements are always on the left side,
        // and the largerLength will be cut in half each round.
        // largerLength is obviously initiated by the array's length.
        int largerLength = array.length;
        // We will terminate when there is only one element left on
        // the larger partition, and it has to be the largest value.
        // the second largest value is the largest value in its
        // compared values.
        while (largerLength > 1) {
            compareAndSwap(helper, largerLength);
            largerLength = (largerLength + 1) / 2;
        }
        return new int[] {helper[0].value, largest(helper[0].compredValues)};
    }

    private Element[] convert(int[] array) {
        Element[] helper = new Element[array.length];
        for (int i = 0; i < array.length; i++) {
            helper[i] = new Element(array[i]);
        }
        return helper;
    }

    // Compare each of the indies pairs (i, largerLength - 1 - i),
    // swap the larger values on the left side if necessary,
    // and put the smaller value into the larger value's compare values list.
    private void compareAndSwap(Element[] helper, int largerLength) {
        for (int i = 0; i < largerLength / 2; i++) {
            if (helper[i].value < helper[largerLength - 1 - i].value) {
                swap(helper, i, largerLength - 1 - i);
            }
            helper[i].compredValues.add(helper[largerLength - 1 - i].value);
        }
    }

    private void swap(Element[] helper, int left, int right) {
        Element temp = helper[left];
        helper[left] = helper[right];
        helper[right] = temp;
    }

    private int largest(List<Integer> list) {
        // This is guaranteed to be O(1).
        int max = list.get(0);
        // Using Iterator is guaranteed to be O(1) traversing each of the
        // elements in the list.
        for (int num : list) {
            max = Math.max(max, num);
        }
        return max;
    }
}

