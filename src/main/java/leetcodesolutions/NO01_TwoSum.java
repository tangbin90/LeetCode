package leetcodesolutions;

import java.util.HashMap;
import java.util.Map;

/**
 * @author TangBin
 * @version V1.0
 * @date 23/03/2018 4:46 PM
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

 */
public class NO01_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numPosition = new HashMap<>();
        int num1 = -1;
        int num2 = -1;
        for(int i=0;i<nums.length;i++){
            if(!numPosition.containsKey(target-nums[i])){
                numPosition.put(nums[i],i);
            }else{
                num1 = numPosition.get(target-nums[i]);
                num2 = i;
            }
        }

        if(num1<0||num2<0)
            return null;
        int[] numRes = new int[2];
        numRes[0] = num1;
        numRes[1] = num2;
        return numRes;
    }

    public static void main(String[] args) {
        int[] nums= new int[]{3,2,4};
        NO01_TwoSum twoSum = new NO01_TwoSum();
        twoSum.twoSum(nums,6);
    }
}
