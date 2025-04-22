package labula;

import entity.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class RobHouses {

    public static int[] mem;
    //dp[i] -> x start from i max rob number dp[i]
    public static int rob(int[] nums){
        int n = nums.length;
        if(n==0) return 0;
        if(n==1) return nums[0];

        mem = new int[n];
        return dp(nums, 0);
    }

    public static int dp(int[] nums, int start){
        if(start >= nums.length)
            return 0;

        int res = Math.max(dp(nums, start+1), nums[start]+dp(nums, start+2));
        return res;
    }

    // dp[i][j]
    int robRange(int[] nums, int start){
        int n = nums.length;
        int[] dp = new int[n];

        dp[n-1] = nums[n-1];
        dp[n] = 0;
        dp[n+1]=0;
        for(int i=n-1; i>=0; i--){
            dp[i] = Math.max(dp[i+1], dp[i+2]+nums[i]);
        }

       return dp[0];
    }

    int robRange(int[] nums, int start, int end){
        int n=nums.length;
        int[] dp = new int[n+2];
        int dp_i_1 =0;
        int dp_i_2 = 0;
        for(int i=end; i>=start; i--){
            dp[i] =Math.max(dp_i_2+nums[i], dp_i_1);
            dp_i_2 = dp_i_1;
            dp_i_1 = dp[i];
        }
        return dp[start];
    }

    int robRange(int[] nums){
        int n=nums.length;

        if(n==1) return nums[0];
        return Math.max(robRange(nums, 0, n-2), robRange(nums, 1, n-1));
    }

    Map<TreeNode, Integer> memDic = new HashMap<>();
    int rob(TreeNode root){
        if(root == null) return 0;

        if(memDic.containsKey(root))
            return memDic.get(root);

        int rob = root.val +
                (root.left == null? 0 : rob(root.left.left  ) + rob(root.left.right))
                +(root.right == null? 0 : rob(root.right.left) + rob(root.right.right));

        int not_rob = rob(root.left)+rob(root.right);
        int res = Math.max(rob, not_rob);
        memDic.put(root, res);
        return res;

    }
}
