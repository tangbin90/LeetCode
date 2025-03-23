package leetcodesolutions;

import entity.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * @author TangBin
 * @version V1.0
 * @date 02/12/2017 9:16 PM
 */
public class NO57_InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int i = 0;
        List<Interval> result = new ArrayList<>();

        while(i<intervals.size()&&intervals.get(i).end<newInterval.start){
            result.add(intervals.get(i));
            i++;
        }

        while(i<intervals.size()&&intervals.get(i).start<=newInterval.end){
            newInterval = new Interval(
                    Math.min(newInterval.start, intervals.get(i).start),
                    Math.max(newInterval.end, intervals.get(i).end));
            i++;
        }
        result.add(newInterval);
        while(i<intervals.size()){
            result.add(intervals.get(i++));
        }
        return result;
    }


}
