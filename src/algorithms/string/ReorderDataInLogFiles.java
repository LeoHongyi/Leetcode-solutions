package algorithms.string;

import java.util.Arrays;
import java.util.Comparator;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://leetcode.com/problems/reorder-data-in-log-files/
 */

public class ReorderDataInLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int s1SpaceIndex = s1.indexOf(' ');
                int s2SpaceIndex = s2.indexOf(' ');
                char s1FollowingChar = s1.charAt(s1SpaceIndex+1);
                char s2FollowingChar = s2.charAt(s2SpaceIndex+1);

                if (s1FollowingChar <= '9') {
                    // char <= 9 is digit log
                    if (s2FollowingChar <= '9') {
                        return 0;
                    } else {
                        return 1;
                    }
                }
                if (s2FollowingChar <= '9') {
                    return -1;
                }

                int preCompute = s1.substring(s1SpaceIndex+1).compareTo(s2.substring(s2SpaceIndex+1));
                if (preCompute == 0) {
                    return s1.substring(0,s1SpaceIndex).compareTo(s2.substring(0,s2SpaceIndex));
                }
                return preCompute;
            }
        });
        return logs;
    }
}