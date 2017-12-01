import javax.swing.event.InternalFrameEvent;
import java.util.*;

/**
 * @author: 17082720 tangbin
 * @create: 2017/12/1 15:10
 * @description:
 * /**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

public class MergeSection {

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> listInterval = new ArrayList<>();
        if(intervals.isEmpty())
            return listInterval;
        intervals.sort(new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                return a.start - b.start;
            }
        });
        Interval intervalBase = intervals.get(0);
        for(Interval interval : intervals){
            if(interval.start>intervalBase.end){
                listInterval.add(intervalBase);
                intervalBase= new Interval(interval.start, interval.end);
            }else{
                int end = interval.end;
                if(end>intervalBase.end){
                    intervalBase.end=end;
                }
            }
        }
        listInterval.add(intervalBase);
        return listInterval;
    }



    public static void main(String[] args){
        List<Interval> list = new ArrayList<>();
        Interval interval1 = new Interval(2,3);
        Interval interval2 = new Interval(5,5);
        Interval interval3 = new Interval(2,2);

        Interval interval4 = new Interval(3,4);
        Interval interval5 = new Interval(3,4);


        list.add(interval1);
        list.add(interval2);
        list.add(interval3);
        list.add(interval4);
        list.add(interval5);
        list = new MergeSection().merge(list);
        for(Interval interval: list)
            System.out.println(interval.start+" "+interval.end);
    }
}
