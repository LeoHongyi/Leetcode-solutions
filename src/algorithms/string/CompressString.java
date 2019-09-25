package algorithms.string;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/173
 * Method: slow, fast pointer
 *  compress all the duplicate letters, ignore all the single letters,
 *  shorten the array
 */
public class CompressString {
    public String compress(String input) {
        // Write your solution here
        char[] array = input.toCharArray();
        return compressDuplicate(array);
    }
    private String compressDuplicate(char[] array) {
        int slow = 0;
        int fast = 0;
        int fastBegin = 0;
        while (fastBegin < array.length) {
            int count = 0;
            while (fast < array.length && array[fast] == array[fastBegin]) {
                count++;
                fast++;
            }
            array[slow++] = array[fastBegin];
            if (count != 1) {
                // translate int to char
                String countString = String.valueOf(count);
                for (int i = 0; i < countString.length(); i++) {
                    array[slow++] = countString.charAt(i);
                }
            }
            fastBegin = fast;
        }
        return new String(array, 0, slow);
    }
}
