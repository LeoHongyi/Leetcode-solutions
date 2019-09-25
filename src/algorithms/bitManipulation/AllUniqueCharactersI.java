package algorithms.bitManipulation;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/76
 * Method: bit operations, int has 32 bit signed two's complement integer
 *  31 ... 25 24 23 ... 3 2 1
 *  0 0 0 0 z  y  x ....c b a
 *  0 0 0 0 0  0  0     1 0 0
 */
public class AllUniqueCharactersI {
    public boolean allUnique(String word) {
        // Write your solution here
        int occuredCharacters = 0;
        for (int i = 0; i < word.length(); i++) {
            int k = word.charAt(i) - 'a';
            // Whether occuredCharacter's kth bit is one (Building block #1)
            // solution 1: x & (1 << k)
            // solution 2: (x >> k) & 1
            if (((occuredCharacters >> k) & 1) == 1) {
                return false;
            }
            occuredCharacters |= (1 << k);
        }
        return true;
    }
}
