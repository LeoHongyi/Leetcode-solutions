package algorithms.dynamicProgramming;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/176
 * Assumption: s, t are not null.
 */
public class LongestCommonSubstring {
    public String longestCommon(String source, String target) {
        // Write your solution here
        int m = source.length();
        int n = target.length();
        int[][] matrix = new int[m + 1][n + 1];
        int start = 0;
        int max = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (source.charAt(i - 1) == target.charAt(j - 1)) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                    if (matrix[i][j] > max) {
                        max = matrix[i][j];
                        start = i - max;
                    }
                } else {
                    matrix[i][j] = 0;
                }
            }
        }
        return source.substring(start, start + max);
    }
}