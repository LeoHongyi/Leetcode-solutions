package String;

/**
 Decompress String, in this form, String is extend
 Method: slow and fast pointer
 slow: [slow - 1, end] are the letters to return
 fast: [fast - 1, end] are the letters that processed
 **/
public class DecompressStringI {
    public String decompress(String input) {
        // Write your solution here
        if (input == null) {
            return input;
        }
        char[] array = input.toCharArray();
        int count = 0;
        int numOfDigits = 0;
        for (int i = 0; i < array.length; i++) {
            // array[i] is a digit
            if (isDigit(array[i])) {
                numOfDigits++;
                count += array[i] - '0';
            }
        }
        char[] result = new char[array.length + count - numOfDigits * 2];
        int slow = array.length + count - numOfDigits * 2 - 1;
        int fast = array.length - 1;
        while (fast >= 0) {
            if (!isDigit(array[fast])) {
                result[slow--] =  array[fast--];
            } else {
                // a[fast] is digit, expand the segment
                // translate char '3' to int 3
                int digit = array[fast--] - '0';
                char dupChar = array[fast--];
                for (int i = 0; i < digit; i++) {
                    result[slow--] = dupChar;
                }
            }
        }
        return new String(result);
    }
    private boolean isDigit(char target) {
        return target >= '0' && '9' >= target;
    }
}
