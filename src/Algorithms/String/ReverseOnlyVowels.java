package Algorithms.String;
/**
 Method: slow, fast pointer, interative
 **/
public class ReverseOnlyVowels {
    public String reverse(String input) {
        // Write your solution here
        // sanity check
        if (input == null || input.length() <= 1) {
            return input;
        }
        char[] array = input.toCharArray();
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            while (left < right && !isVowel(array[left])) {
                left++;
            }
            while (left < right && !isVowel(array[right])){
                right--;
            }
            swap(array, left++, right--);
        }
    return new String(array);
}
    private boolean isVowel(char c) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        for (int i = 0; i < vowels.length; i++) {
            if (vowels[i] == c) {
                return true;
            }
        }
        return false;
    }
    private void swap(char[] array, int left, int right) {
        char temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}