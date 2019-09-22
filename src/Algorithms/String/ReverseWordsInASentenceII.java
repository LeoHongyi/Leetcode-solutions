package Algorithms.String;

/**
 problem type: reverse string, deduplicate space
 Method: slow, fast pointer
 [0, index - 1]: are the result to return
 [start, i]: are the word to reverse, deduplicate space, and then copy to result
 [i, array.length - 1] unknown part needs to process
 **/
public class ReverseWordsInASentenceII {
    public String reverseWords(String input) {
        // Write your solution here
        if (input == null || input.length() <= 1) {
            return input;
        }
        char[] array = input.toCharArray();
        int start = 0;
        int index = 0;
        // reverse the whole array
        reverse(array, 0, array.length - 1);
        // step 1: reverse each word in the array
        for (int i = 0; i < array.length; i++) {
            if (array[i] != ' ' && (i == 0 || array[i - 1] == ' ')) {
                start = i;
            }
            if (array[i] != ' ' && (i == array.length - 1 || array[i + 1] == ' ')) {
                reverse(array, start, i);
            }
        }
        // step 2: deduplicate the space
        return deduplicate(array);
    }

    private String deduplicate(char[] array) {
        int slow = 0;
        for (int fast = 0; fast < array.length; fast++) {
            if (array[fast] == ' ' && (fast == 0 || array[fast - 1] == ' ')) {
                continue;
            } else {
                array[slow++] = array[fast];
            }
        }
        // corner case: letter_, the one space after the string
        if (slow > 0 && array[slow - 1] == ' ') {
            return new String(array, 0, slow - 1);
        }
        return new String(array, 0 ,slow);
    }

    private void reverse(char[] array, int left, int right) {
        while (left < right) {
            swap(array, left, right);
            left++;
            right--;
        }
    }
    private void swap(char[] array, int left, int right) {
        char temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}

