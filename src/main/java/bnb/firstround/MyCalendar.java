package bnb.firstround;

import java.util.*;

/**
 * You are implementing a program to use as your calendar. We can add a new event if adding the event will not cause a double booking.
 *
 * A double booking happens when two events have some non-empty intersection (i.e., some moment is common to both events.).
 *
 * The event can be represented as a pair of integers startTime and endTime that represents a booking on the half-open interval [startTime, endTime), the range of real numbers x such that startTime <= x < endTime.
 *
 * Implement the MyCalendar class:
 *
 * MyCalendar() Initializes the calendar object.
 * boolean book(int startTime, int endTime) Returns true if the event can be added to the calendar successfully without causing a double booking. Otherwise, return false and do not add the event to the calendar.
 *
 *
 * Example 1:
 *
 * Input
 * ["MyCalendar", "book", "book", "book"]
 * [[], [10, 20], [15, 25], [20, 30]]
 * Output
 * [null, true, false, true]
 *
 * Explanation
 * MyCalendar myCalendar = new MyCalendar();
 * myCalendar.book(10, 20); // return True
 * myCalendar.book(15, 25); // return False, It can not be booked because time 15 is already booked by another event.
 * myCalendar.book(20, 30); // return True, The event can be booked, as the first event takes every time less than 20, but not including 20.
 */
public class MyCalendar {

    TreeMap<Integer, Integer> calendar2;


    public boolean book2(int startTime, int endTime) {
        Integer ceilling = calendar2.ceilingKey(startTime);
        if(ceilling != null && ceilling < endTime) return false;

        Integer floor = calendar2.floorKey(startTime);
        if(floor != null && calendar2.get(floor) > startTime) return false;

        calendar2.put(startTime, endTime);

        return true;
    }
    LinkedList<int[]> calendar;
    public MyCalendar() {
        calendar= new LinkedList<>();
    }

    public boolean book(int startTime, int endTime) {
        int pos = 0;
        for(int[] pair : calendar){
            if(pair[0] >= endTime){
                break;
            } else {
                if(Math.max(pair[0], startTime) < Math.min(pair[1], endTime)){
                    return false;
                } else
                    pos++;
            }
        }

        if(pos == calendar.size()){
            calendar.add(new int[]{startTime, endTime});
        } else {
            calendar.add(pos, new int[]{startTime, endTime});
        }

        return true;
    }


    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();

        System.out.println(myCalendar.book(10, 20));
        System.out.println(myCalendar.book(20,30));
        System.out.println(myCalendar.book(20,30));


    }
}
