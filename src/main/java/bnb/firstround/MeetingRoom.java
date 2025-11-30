package bnb.firstround;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoom {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b)-> a[1] - b[1]);
        int len = intervals.length;
        int rslt = 0;
        for(int i = 0; i < len; i++){
            int[] currInterval = intervals[i];

            while(!queue.isEmpty() && queue.peek()[1] <= currInterval[0]){
                queue.poll();
            }
            queue.add(currInterval);
            rslt = Math.max(queue.size(), rslt);
        }

        return rslt;

    }

    public int minMeetingRooms2(int[][] intervals) {
        int len = intervals.length;
        int[] begin = new int[len];
        int[] end = new int[len];
        int curr = 0;
        int rslt = 0;
        int index = 0;
        for(int[] interval : intervals){
            begin[index] = interval[0];
            end[index] = interval[1];
            index++;
        }

        Arrays.sort(begin);
        Arrays.sort(end);

        int endPtr = 0;
        for(int i=0; i<len ; i++){
            if(begin[i] < end[endPtr]){
                curr++;
                rslt = Math.max(curr, rslt);
            } else {
                curr--;
                endPtr++;
            }
        }

        return rslt;

    }
}
