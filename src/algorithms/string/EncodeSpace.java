package algorithms.string;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/83
 * algorithms.string replace " " with "20%" that get longer
 *  Method: slow, fast pointer from right to left because the extension
 */
public class EncodeSpace {
    public String encode(String input) {
        // Write your solution here
        char[] array = input.toCharArray();
        int spaceCount = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == ' ') {
                spaceCount++;
            }
        }
        char[] result = new char[array.length + spaceCount * 2];
        int slow = array.length + spaceCount * 2 - 1;
        int fast = array.length - 1;
        while (fast >= 0) {
            if (array[fast] != ' ') {
                result[slow--] = array[fast--];
            } else {
                fast--;
                result[slow--] = '%';
                result[slow--] = '0';
                result[slow--] = '2';
            }
        }
        return new String(result);
    }
}
