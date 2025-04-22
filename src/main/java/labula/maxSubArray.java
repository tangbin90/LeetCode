package labula;

public class maxSubArray {
    public static int maxSubArrayFunc(int[] nums){
        int[] dp = new int[nums.length];

        dp[0] = nums[0];

        for(int i=1; i < nums.length; i++){
            dp[i] = Math.max(nums[i], dp[i-1] + nums[i]);
        }

        int result = Integer.MIN_VALUE;
        for(int i=0; i < nums.length; i++)
            result = Math.max(result, dp[i]);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-3, 1, 3, -1, 2, -4, 2};
        System.out.println(maxSubArrayFunc(nums));
    }
}
