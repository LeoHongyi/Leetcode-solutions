package algorithms.sort;

import java.util.Arrays;
/**
 * @author Qihao He
 * @date 09/29/2019
 * https://leetcode.com/problems/meeting-rooms-ii/
 * https://app.laicode.io/app/problem/494
 */
public class MeettingRoomsII {
    public int minMeetingRooms1(Interval[] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for(int i=0; i<intervals.length; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int counts = 0;
        int endsIndex = 0;
        for (int i = 0; i < starts.length; i++) {
            if (starts[i] < ends[endsIndex]) {
                counts++;
            } else {
                endsIndex++;
            }
        }
        return counts;
    }

    class Interval{
        int start;
        int end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int minMeetingRooms2(int[][] intervals) {
        // sanity check
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) {
            return 0;
        }
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int counts = 0;
        int endsIndex = 0;
        for (int i = 0; i < starts.length; i++) {
            if (starts[i] < ends[endsIndex]) {
                counts++;
            } else {
                endsIndex++;
            }
        }
        return counts;
    }
}
