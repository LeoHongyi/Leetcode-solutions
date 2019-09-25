package algorithms.bitManipulation;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/77
 */
public class AllUniqueCharactersII {
    public boolean allUnique(String word) {
        // Write your solution here
        int[] bitVector = new int[8];
        char[] array = word.toCharArray();
        for (char c : array) {
            if ((bitVector[c / 32] >>> (c % 32) & 1) != 0) {
                return false;
            }
            //
            bitVector[c / 32] |= 1 << (c % 32);
        }
        return true;
    }
}
