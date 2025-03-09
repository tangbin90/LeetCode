import java.util.ArrayList;
import java.util.List;

public class MonotonicQueue {

    public void push(int n){

    }

    public int max(){

    }

    public void pop(int n){

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
