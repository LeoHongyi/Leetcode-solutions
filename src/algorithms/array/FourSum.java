package algorithms.array;

import java.util.Arrays;

/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/188
 * Assumption: array is not null, length >=4
 *  Method 2: class Element record a pair of numbers in the array.
 *  O(n^n * logn) get all pairs of numbers and apply 2 sum.
 */
public class FourSum {

    public boolean exist(int[] array, int target) {
        // Write your solution here
        // sort array first, and find i,j,k,l such that
        // i<j<k<l, and the sum is target.
        // we split the tuples into two pair elements: (i,j) and (k,l),
        // so that array[i] + array[j] <= array[k] + array[l].
        Arrays.sort(array);
        Element[] pairSum = getPairSum(array);
        Arrays.sort(pairSum);
        int left = 0;
        int right = pairSum.length - 1;
        // pairSum are sorted by sum, then right index, then left index.
        while (left < right) {
            // only return true if two pair sum's sum is target and the larger pair
            // sum's left > smaller pair sum's larger index.
            if (pairSum[left].sum + pairSum[right].sum == target &&
                    pairSum[left].right < pairSum[right].left) {
                return true;
            } else if (pairSum[left].sum + pairSum[right].sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }
    private Element[] getPairSum(int[] array) {
        Element[] pairSum = new Element[array.length * (array.length - 1) / 2];
        int curIndex = 0;
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                pairSum[curIndex++] = new Element(j, i, array[i] + array[j]);
            }
        }
        return pairSum;
    }
    static class Element implements Comparable<Element> {
        int left;
        int right;
        int sum;

        Element(int left, int right, int sum) {
            this.left = left;
            this.right = right;
            this.sum = sum;
        }
        // we define the order of the element:
        // first by the sum value, then by the right index, then by the left index.
        @Override
        public int compareTo(Element another) {
            if (this.sum != another.sum) {
                return this.sum < another.sum ? -1 : 1;
            } else if (this.right != another.right) {
                return this.right < another.right ? -1 : 1;
            } else if (this.left < another.left) {
                return this.left < another.left ? -1 : 1;
            }
            return 0;
        }
    }
}
