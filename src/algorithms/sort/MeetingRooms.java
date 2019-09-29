package algorithms.sort;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals == null) {
            return false;
        }
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] i1, int[] i2){
                return i1[0]-i2[0];
            }
        });
        for(int i=0; i<intervals.length-1; i++) {
            if(intervals[i+1][0]<intervals[i][1]){
                return false;
            }
        }
        return true;
    }
}