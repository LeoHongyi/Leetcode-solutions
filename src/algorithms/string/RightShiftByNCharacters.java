package algorithms.string;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/397
 */
public class RightShiftByNCharacters {
    public String rightShift(String input, int n) {
        // Write your solution here
        if (input.length() <= 1) {
            return input;
        }
        char[] array = input.toCharArray();
        n %= array.length;
        reverse(array, array.length - n, array.length - 1);
        reverse(array, 0, array.length - n - 1);
        reverse(array, 0, array.length - 1);
        return new String(array);
    }
    private void reverse(char[] array, int left, int right) {
        while (left < right) {
            char temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }
}
