package Algorithms.String;
/**
 Method 1: O(n^2)
 for i to i + t.length() - 1 = s.length() - 1
 **/
public class ValidAnagram {
    public boolean isAnagram(String source, String target) {
        // Write your solution here
        // sanity check
        if (source == null || target == null){
            return false;
        } else if (source.isEmpty()) {
            return false;
        } else if (target.isEmpty()) {
            return false;
        } else if (source.length() < target.length()) {
            return false;
        }
        for (int i = 0; i <= source.length() - target.length(); i++) {
            int j = 0;
            for (; j < target.length(); j++) {
                if (source.charAt(i + j) != target.charAt(j)) {
                    break;
                }
            }
            if (j == target.length()) {
                return true;
            }
        }
        return false;
    }
}
