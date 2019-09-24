package algorithms.string;
import java.util.ArrayList;

public class StringReplace {
    /**
     * @author Qihao He
     * @date 09/24/2019
     * https://app.laicode.io/app/problem/649
     */
//Method 1: Not using any algorithms.string/StringBuilder utility, and using char[] to do it "in place".
    public String replace(String input, String source, String target) {
        // Write your solution here
        //Assumption: input, s, t are not null, s is not empty string
        char[] array = input.toCharArray();

        if (source.length() >= target.length()) {
            return replaceShorter(array, source, target);
        }
        return replaceLonger(array, source, target);
    }
    //case 1: if s.length() >= t.length()
    //Step 1: find every single occurrence of s in the original string, and just replace s with t, until we are done.
    public String replaceShorter(char[] input, String s, String t) {
        // We reuse the input char array since the number of characters needed is less.
        // fast and slow pointers both from left to right direction.
        int slow = 0;
        int fast = 0;
        while (fast < input.length) {
            // When we find a match of s on the substring starting from the fast pointer,
            // we copy the t at the slow pointer.
            if (fast <= input.length - s.length() && equalSubstring(input, fast, s)) {
                copySubstring(input, slow, t);
                slow += t.length();
                fast += s.length();
            } else {
                input[slow++] = input[fast++];
            }
        }
        return new String(input, 0, slow);
    }
    //case 2: if s.length() < t.length()
    //How many extra spaces should we get?
    //Step 1: count how many times s1 show up in the original string. for example: 2 times
    //Step 2: 2 * (t.size() - s.size())
    public String replaceLonger(char[] input, String s, String t) {
        ArrayList<Integer> matches = getAllMatches(input, s);
        char[] result = new char[input.length + matches.size() * (t.length() - s.length())];
        int lastIndex = matches.size() - 1;
        int fast = input.length - 1;
        int slow = result.length - 1;
        while (fast >= 0) {
            //only if we still have some match and slow is in the position of
            //rightmost matching and position, we should copy t.
            if (lastIndex >= 0 && fast == matches.get(lastIndex)) {
                copySubstring(result, slow - t.length() + 1, t);
                slow -= t.length();
                fast -= s.length();
                lastIndex--;
            } else {
                result[slow--] = input[fast--];
            }
        }
        return new String(result);
    }
    //check if the substring from fromIndex is the same as s.
    private boolean equalSubstring(char[] input, int fromIndex, String s) {
        for (int i = 0; i < s.length(); i++) {
            if (input[fromIndex + i] != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    // copy the string t to result at fromIndex
    private void copySubstring(char[] result, int fromIndex, String t) {
        for (int i = 0; i < t.length(); i++) {
            result[fromIndex + i] = t.charAt(i);
        }
    }
    private ArrayList<Integer> getAllMatches(char[] input, String s) {
        ArrayList<Integer> matches = new ArrayList<Integer>();
        int i = 0;
        while (i <= input.length - s.length()) {
            if (equalSubstring(input, i, s)) {
                // we record the match substring's end index instead of start index,
                // for later convenience.
                matches.add(i + s.length() - 1);
                i += s.length();
            } else {
                i++;
            }
        }
        return matches;
    }
}