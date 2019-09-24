package algorithms.string;

public class RemoveSpaces {
    /**
     * @author Qihao He
     * @date 09/24/2019
     * https://app.laicode.io/app/problem/281
     * case 1: if a[j] == ' ', if i == 0, if i != 0
     * case 2: if a[j] != ' '
     */
    public String removeSpaces(String input) {
        // Write your solution here
        if (input.isEmpty()) {
            return input;
        }
        char[] array = input.toCharArray();
        int slow = 0;
        for (int fast = 0; fast < input.length(); fast++) {
            if (array[fast] == ' ' && (fast == 0 || array[fast - 1] == ' ')) {
                continue;
            } else {
                array[slow++] = array[fast];
            }
        }
        if (slow > 0 && array[slow - 1] == ' ') {
            return new String(array, 0, slow - 1);
        }
        return new String(array, 0, slow);
    }
}