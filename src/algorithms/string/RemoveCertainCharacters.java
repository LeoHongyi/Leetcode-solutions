package algorithms.string;

import java.util.HashSet;
import java.util.Set;

public class RemoveCertainCharacters {
    /**
     * @author Qihao He
     * @date 09/24/2019
     * https://app.laicode.io/app/problem/395
     * hashset
     */
    public String remove(String input, String t) {
        // Write your solution here
        char[] array = input.toCharArray();
        Set<Character> set = buildSet(t);
        int slow = 0;
        for (int fast = 0; fast < array.length; fast++) {
            if (!set.contains(array[fast])) {
                array[slow++] =  array[fast];
            }
        }
        return new String(array, 0, slow);
    }
    private Set<Character> buildSet(String t) {
        Set<Character> set = new HashSet<Character>();
        for (int i = 0; i < t.length(); i++) {
            set.add(t.charAt(i));
        }
        return set;
    }
}