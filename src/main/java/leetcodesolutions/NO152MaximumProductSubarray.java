package leetcodesolutions;

public class NO152MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int min = 1;
        int max = 1;
        int ans = Integer.MIN_VALUE;

        for(int i=0; i< nums.length; i++){
            int tmp = max;
            max = Math.max(nums[i], Math.max(max*nums[i], min*nums[i]));
            min = Math.min(nums[i], Math.min(tmp*nums[i], min*nums[i]));
            ans = Math.max(max, ans);
        }
        return ans;
    }

}
