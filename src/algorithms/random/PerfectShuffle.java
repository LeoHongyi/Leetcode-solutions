package algorithms.random;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/108
 */
public class PerfectShuffle {
    public void shuffle(int[] array) {
        // Write your solution here.
        if (array.length <= 1) {
            return;
        }
        // from right to left,
        // for index i - 1, randomly pick one of the first i elements.
        for (int i = array.length; i >= 1; i--) {
            // randomIndex range [0,i) -> [0,i-1]
            int randomIndex = (int)(Math.random() * i);
            swap(array, i - 1, randomIndex);
        }
    }
    private void swap(int[] array, int left,  int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
