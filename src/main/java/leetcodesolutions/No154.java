package leetcodesolutions;

public class No154 {
    public int findMin(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        int current = 0;
        int rslt = nums[0];
        for(int i=0; i < nums.length-1; i++){
            if(nums[current] <= nums[current+1]) {
                current++;
            }
            else
                break;
        }

        if(current==nums.length-1)
            return rslt;
        else
            rslt = nums[current+1];

        return rslt;
    }
}
