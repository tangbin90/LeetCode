package labula;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MonotonicQueue {
    private LinkedList<Integer> q = new LinkedList<>();

    public void push(int n){
        while(!q.isEmpty() && q.getLast() < n) {
            q.pollLast();
        }
        q.addLast(n);
    }

    public int max(){
        return q.getFirst();
    }

    public void pop(int n){
        if(n==q.getFirst())
            q.pollFirst();
    }

    public static List<Integer> maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue window = new MonotonicQueue();
        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            if(i < k-1){
                window.push(nums[i]);
            } else {
                window.push(nums[i]);
                res.add(window.max());
                window.pop(nums[i-k+1]);
            }
        }
        return res;
    }
}
