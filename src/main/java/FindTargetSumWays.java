import java.util.HashMap;

public class FindTargetSumWays {

    private int result = 0;

    public int findTargetSumWays(int[] nums, int target){
        return backtrack(nums, 0, target);
    }

    public int backtrack(int[] nums, int index, int rest){
        if(index==nums.length){
            if(rest == 0)
                result++;
            return result;
        }

        result += nums[index];
        backtrack(nums, index+1, result);
        result -= nums[index];

        result -= nums[index];
        backtrack(nums, index+1, result);
        result += nums[index];

        return result;
    }

    HashMap<String, Integer> mem = new HashMap<>();

    int dp(int[] nums, int start, int sum,  int result){
        if(start == nums.length) {
            if (sum == result) return 1;
            else return 0;
        }

        String key = start + ":" + sum;
        mem.put(key, sum);

        int res = dp(nums, start+1, sum+nums[start], result)
                + dp(nums, start+1, sum-nums[start], result);

        mem.put(key, result);
        return res;
    }

}
