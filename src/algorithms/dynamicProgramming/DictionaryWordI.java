package algorithms.dynamicProgramming;

import java.util.HashSet;
import java.util.Set;

public class DictionaryWordI {
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/99
 * Method: DP
 *  O(n^2)
 */
    public boolean canBreak(String input, String[] dict) {
        // Write your solution here
        Set<String> dictSet = toSet(dict);
        boolean[] canBreak = new boolean[input.length() + 1];
        // canBreak[0] = true, because when dict has the whole word inside,
        // it need the RHS canBreak[0]
        canBreak[0] = true;
        for (int i = 1; i < canBreak.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dictSet.contains(input.substring(j, i)) && canBreak[j]) {
                    canBreak[i] = true;
                    break;
                }
            }
        }
        return canBreak[canBreak.length - 1];
    }
    private Set<String> toSet(String[] dict) {
        Set<String> dictSet = new HashSet<>();
        for (String string : dict) {
            if (!dictSet.contains(string)) {
                dictSet.add(string);
            }
        }
        return dictSet;
    }
}
