package bnb.firstround;

import java.util.ArrayList;
import java.util.List;

public class CalendarII {
    List<int[]> book;
    List<int[]> overlap;
    public CalendarII() {
        book = new ArrayList<>();
        overlap = new ArrayList<>();
    }

    public boolean book(int startTime, int endTime) {
        for(int[] inverval : overlap){
            int l = Math.max(startTime, inverval[0]);
            int r = Math.min(endTime, inverval[1]);
            if(l < r){
                return false;
            }
        }

        for(int[] interval : book){
            int l = Math.max(startTime, interval[0]);
            int r = Math.min(endTime, interval[1]);

            if(l < r){
                overlap.add(new int[]{l, r});
            }
        }

        book.add(new int[]{startTime, endTime});

        return true;
    }
}
