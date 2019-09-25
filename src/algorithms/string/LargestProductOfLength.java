package algorithms.string;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/191
 * Assumption: all letters in the word is from 'a-z' in ASCII, and sorted in length.
 *  Best First Search, start with the longest string and second longest string
 *  1. initial state <s1 * s2>
 *  2. expansion / generation rule
 *  expand a state <si * sj>
 *  generate <si + 1 * sj>
 *  generate <si * sj + 1>
 *  3. termination condition
 *  when we expanded a state <si * sj> such that si and sj do not have
 *  any common elements -> found a solution
 *  PQ is empty -> no answer
 *  4. deduplication
 *  might generate the same state multiple times,
 *  it does not affect the correctness of this problem, but the efficiency may be worse.
 *  time:
 *  There are at most O(n^2) states {
 *  step 1: heap.pop() worst case heap.size == O(n^2)    O(log(n^2))
 *  step 2: compare two strings to find if they have common elements O(m)
 *  }
 *  Total time: O(n^2 * (log(n^2) + m))
 */
public class LargestProductOfLength {
    public int largestProduct(String[] dict) {
        // Write your solution here
        // get the bit mask for each of the word in the dict,
        // the bit mask is represented by the lowest 26 bits of an integer.
        // each of the bit represents one of the characters in 'a' - 'z'.
        HashMap<String, Integer> bitMasks = getBitMasks(dict);
        // sort the dict by length of the words in descending order.
        Arrays.sort(dict, new Comparator<String>() {
            @Override
            public int compare(String s0, String s1) {
                if (s0.length() == s1.length()) {
                    return 0;
                }
                return s0.length() < s1.length() ? 1 : -1;
            }
        });
        int largest = 0;
        // note the order of constructing all the pairs,
        // we make out best to try largest product.
        for (int i = 1; i < dict.length; i++) {
            for (int j = 0; j < i; j++) {
                //early break if the product is already smaller than
                // the current largest one.
                int prod = dict[i].length() * dict[j].length();
                if (prod <= largest) {
                    break;
                }
                int iMask = bitMasks.get(dict[i]);
                int jMask = bitMasks.get(dict[j]);
                // if two words do not share any common characters,
                // the bit masks "and" result should be 0 since
                // there is not any position such that in the two bit masks
                // they are all 1.
                if ((iMask & jMask) == 0) {
                    largest = prod;
                }
            }
        }
        return largest;
    }
    // get the bit mask for each of the words.
    private HashMap<String, Integer> getBitMasks(String[] dict) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String str : dict) {
            int bitMask = 0;
            for (int i = 0; i < str.length(); i++) {
                // the 26 characters 'a' - 'z' are mapped to 0 - 25th bit.
                // to determine which bit it is for a character x,
                // use (x - 'a') since their values are in a consecutive range
                // if character x exists in the word, we set the bit at
                // corresponding index to 1.
                bitMask |= 1 << (str.charAt(i) - 'a');
            }
            map.put(str, bitMask);
        }
        return map;
    }
}
