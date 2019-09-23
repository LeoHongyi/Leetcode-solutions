package algorithms.string;
/**
 Method: slow, fast pointer
 slow: [0, slow - 1] the result to return
 fastBegin: the letter that is waiting for fast to count duplicate
 fast: [0, fast - 1], the letters that are processed.
 a a a a b b b c c c
 s
 fB
 f
 **/
public class RemoveAdjacentRepeatedCharactersIII {
    public String deDup(String input) {
        // Write your solution here
        if (input == null || input.length() <= 1) {
            return input;
        }
        char[] array = input.toCharArray();
        int slow = 0;
        int fastBegin = 0;
        int fast = 0;
        while (fastBegin < array.length) {
            int count = 0;
            // a[fastBegin, fast] maybe duplicate segment
            while (fast < array.length && array[fast] == array[fastBegin]) {
                fast++;
                count++;
            }
            // fastBegin is a single letter, copy
            if (count == 1) {
                array[slow++] = array[fastBegin];
            }
            // fastBegin is NOT a single letter, no copy
            fastBegin = fast;
        }
        return new String(array, 0, slow);
    }
}
