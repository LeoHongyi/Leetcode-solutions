package algorithms.string;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/84
 * Method: iterative, slow and fast pointer
 *  i love google -> elgoog evol i -> google love i
 *  step 1: reverse the whole sentence
 *  step 2: reverse each word in the sentence (slow and fast pointer)
 */
public class ReverseWordsInASentenceI {
    public String reverseWords(String input) {
        // Write your solution here
        if (input == null || input.length() <= 1) {
            return input;
        }
        char[] array = input.toCharArray();
        // step 1: reverse the whole sentence
        reverse(array, 0, array.length - 1);
        // step 2: reverse each word in the sentence
        int start = 0;
        for (int end = 0; end < array.length; end++) {
            // find start of the word, or sentense(corner case).
            if (array[end] != ' ' && (end == 0 || array[end - 1] == ' ')) {
                start = end;
            }
            // find end of the word, or sentence(corner case).
            if (array[end] != ' ' && (end == array.length - 1 || array[end + 1] == ' ')) {
                reverse(array, start, end);
            }
        }
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
