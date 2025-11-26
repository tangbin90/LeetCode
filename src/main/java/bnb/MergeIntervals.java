package bnb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];

        int len = intervals.length;
        List<int[]> ans = new ArrayList<>();

        for(int i=1; i<len ; i++){
            if(intervals[i][0] <= end){
                end = Math.max(end, intervals[i][1]);
            } else {
                ans.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        ans.add(new int[] {start, end});

        int[][] rslt = new int[ans.size()][2];
        for(int i=0; i< ans.size(); i++){
            rslt[i] = ans.get(i);
        }

        return rslt;
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int start = newInterval[0];
        int end = newInterval[1];

        List<int[]> rslt = new ArrayList<>();
        int len = intervals.length;
        for(int i=0; i< len; i++){
            if(intervals[i][1] < start || intervals[i][0] > end){
                rslt.add(intervals[i]);
            }else{
                start = Math.min(intervals[i][0], start);
                end = Math.max(intervals[i][1], end);
            }
        }
        rslt.add(new int[]{start, end});

        int[][] ans = new int[rslt.size()][2];
        for(int i=0; i< rslt.size(); i++){
            ans[i] = rslt.get(i);
        }
        Arrays.sort(ans, (a, b) -> a[0] - b[0]);
        return ans;

    }

}
