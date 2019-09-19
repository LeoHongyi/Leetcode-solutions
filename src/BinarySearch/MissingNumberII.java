package BinarySearch;

public class MissingNumberII {
    public int missing(int[] array) {
        // Write your solution here
        int i = 1;
        for (; i < array.length + 1; i++) {
            if (i != array[i - 1]) {
                return i;
            }
        }
        return i;
    }
}
