package algorithms.string;

public class CompressStringII {
    public String compress(String input) {
        // Write your solution here
        if (input == null || input.length() == 0) {
            return input;
        }
        char[] array = input.toCharArray();
        // First pass: compress duplicates and count singles
        Result result = compressDuplicate(array);
        // Second pass: expand singles
        return expandSingles(array, result.length, result.singleCount);
    }
    // Compress duplicate characters in sequence
    // Returns the new length of sequence after compression and the number of singles
    private Result compressDuplicate(char[] array) {
        int slow = 0;
        int fastBegin = 0;
        int fast = 0;
        int singleCount = 0;
        while (fastBegin < array.length) {
            int count = 0;
            while (fast < array.length && array[fast] == array[fastBegin]) {
                fast++;
                count++;
            }
            if (count == 1) {
                singleCount++;
                array[slow++] = array[fastBegin];
            } else {
                // We could use algorithms.math.log10 to get number of digits of count
                // divide count by decreasing power of 10 to get individual
                // digits. Or we could use algorithms.string utility to covert it to string
                // directly. More space used but less code.
                array[slow++] = array[fastBegin];
                String countString = String.valueOf(count);
                for (int i = 0; i < countString.length(); i++) {
                    array[slow++] = countString.charAt(i);
                }
            }
            fastBegin = fast;
        }
        return new Result(slow, singleCount);
    }
    private String expandSingles(char[] input, int inputLength, int singleCount) {
        char[] output = new char[inputLength + singleCount];
        // [0, fast] letters are not yet processed, (fast, end] letters are processed
        // (slow, end] result to return.
        int slow = output.length - 1;
        int fast = inputLength - 1;
        while (fast >= 0) {
            // Copy if
            // 1) it's digit
            // 2) it's a duplicate letter
            //   2.1) the letter must not appear at the end of input (no digits could appear after that)
            //   2.2) the letter must precede a digit
            // copy the segment, for all the digits or letter following the digit
            if (isDigit(input[fast]) || fast < inputLength - 1 && isDigit(input[fast + 1])) {
                output[slow--] = input[fast--];
            } else {
                // Single character, letter that following letter
                output[slow--] = '1';
                output[slow--] = input[fast--];
            }
        }
        return new String(output);
    }
    private boolean isDigit(char character) {
        return character >= '0' && character <= '9';
    }
    static private class Result {
        int length;
        int singleCount;
        public Result(int len, int singles) {
            length = len;
            singleCount = singles;
        }
    }
}