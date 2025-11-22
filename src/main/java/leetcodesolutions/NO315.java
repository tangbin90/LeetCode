package leetcodesolutions;

import java.util.*;

class NO315 {
    private int[] bits;
    private List<Integer> condenseArray;
    private Map<Integer, Integer> numberToCondenseArrayIndex;

    public void init(int[] nums){
        numberToCondenseArrayIndex = new HashMap<>();
        int[] tmp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(tmp);
        int count = 1;
        numberToCondenseArrayIndex.put(tmp[0], count);
        for(int i=1; i < tmp.length; i++){
            if(tmp[i] == tmp[i-1])
                continue;
            else {
                count ++;
                numberToCondenseArrayIndex.put(tmp[i], count);
            }
        }

        bits = new int[count + 1];

    }
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> rslt = new LinkedList<>();
        init(nums);
        for(int i=nums.length - 1; i >= 0; i--){
            int pos = numberToCondenseArrayIndex.get(nums[i]);
            update(1, pos);
            rslt.add(sum(pos));
        }

        return rslt.reversed();
    }

    private int lowBit(int x){
        return x & (-x);
    }

    private void update(int x, int index){
        for(int i=index; i< bits.length; i+=lowBit(i)){
            bits[i] += x;
        }
    }

    private int sum(int index){
        int rslt = 0;
        for(int i= index-1; i>0; i -= lowBit(i)){
            rslt+=bits[i];
        }

        return rslt;
    }

    public static void main(String[] args) {
        NO315 no315 = new NO315();
        int[] nums = {5,2,6,1};
        List<Integer> rslt = no315.countSmaller(nums);
        System.out.println(rslt); // Output: [2, 1, 1, 0]
    }
}