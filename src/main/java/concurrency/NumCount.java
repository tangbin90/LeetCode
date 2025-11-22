package concurrency;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class NumCount {
// int[] number
    ConcurrentHashMap<Integer, Integer> mem;

    public NumCount(){
        mem = new ConcurrentHashMap<>();
    }
    private  Map<Integer, Integer> countNums(int[]  nums){
        for(int num : nums){
            mem.put(num, mem.getOrDefault(num, 0) + 1);
        }

        return mem;
    }



    public static void main(String[] args) throws InterruptedException {
        NumCount test = new NumCount();
        int[] num = {1,2,1,1,1,1,2,3,4};
        int[] num2 = {1,2,1,1,1,1,2,3,4};


        Thread th1 = new Thread(() -> {
            test.countNums(num);
        });
        Thread th2 = new Thread(() -> {
            test.countNums(num2);
        });
        th1.start();
        th2.start();
        while(th1.isAlive() || th2.isAlive()){
            Thread.sleep(100);
        }
        for (Integer key : test.mem.keySet()){
            System.out.println(key + ", " + test.mem.get(key) + "time(s)");
        }
    }

}
