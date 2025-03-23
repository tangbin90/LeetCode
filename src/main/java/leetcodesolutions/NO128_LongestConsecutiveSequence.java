package leetcodesolutions;

import java.util.HashMap;
import java.util.Map;

/**
 * @author TangBin
 * @version V1.0
 * @date 29/03/2018 6:16 PM
 *
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
 */
public class NO128_LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> mapPath = new HashMap<>();
        int res = 0;
        for(int i=0;i<nums.length;i++){
            if(!mapPath.containsKey(nums[i])){
                int left = mapPath.getOrDefault(nums[i] - 1, 0);
                int right = mapPath.getOrDefault(nums[i]+1, 0);
                int sum = left+right+1;
                res = Math.max(sum, res);
                mapPath.put(nums[i],sum);
                mapPath.put(nums[i]-left,sum);
                mapPath.put(nums[i]+right, sum);
            }else
                continue;
        }
        return res;
    }

    public static void main(String[] args){
        NO128_LongestConsecutiveSequence longestConsecutiveSequence = new NO128_LongestConsecutiveSequence();
        longestConsecutiveSequence.longestConsecutive(new int[]{4,0,-4,-2,2,5,2,0,-8,-8,-8,-8,-1,7,4,5,5,-4,6,6,-3});
    }
}
