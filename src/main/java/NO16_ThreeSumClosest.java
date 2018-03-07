import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author TangBin
 * @version V1.0
 * @date 11/04/2017 10:51 AM
 */
public class NO16_ThreeSumClosest {
    public static int threeSumClosestToTarget(int[] nums, int target) {
        Arrays.sort(nums);
        int com = Integer.MAX_VALUE;
        int result=0;
        for(int i=0;i+2<nums.length;i++){
            int j = i + 1;
            int tail = nums.length - 1;
            int closeTo=target-nums[i];
            while (j < tail) {
                int tempInt=Math.abs(nums[j]+nums[tail]-closeTo);
                if(com>tempInt) {
                    com = tempInt;
                    result=nums[i]+nums[j]+nums[tail];
                }
                if (nums[j] + nums[tail] == closeTo) {
                    return target;
                } else if (nums[j] + nums[tail] < closeTo) {
                    j++;
                } else
                    tail--;
            }
        }

        return result;
    }

    public static void main(String[] args){
        int[] nums = new int[]{1,1,1,1};
        int lli = threeSumClosestToTarget(nums,-100);
        System.out.println(lli);
        }
}
