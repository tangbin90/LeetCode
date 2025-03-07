import static java.lang.Math.max;

public class Balloon {
    public static int res = Integer.MIN_VALUE;

    public static int maxCoins(int[] nums){
        backtrack(nums, 0);
        return res;
    }

    public static void backtrack(int[] nums, int score) {
        if(nums.length==0){
            res =  max(res, score);
            return;
        }

        for(int i=0; i<nums.length; i++){
            int point = nums[i-1] * nums[i] * nums[i+1];
            int temp = nums[i];

            //delete nums[i]
            backtrack(nums, score+point);
            //undelete nums[i]
        }
    }


    //bp:dp[i][j], maxCoins between i and j
    // i=0 dp[0][0] = 1 dp[0][n+1]
    //dp[i][j] the highest scores from pos i and j
    //last poked balloon k
    //nums[k]*num[i]*nums[j] + dp[i][k] + dp[k][j]
    public int maxCoins2(int[] nums){
        int n = nums.length;
        int[][] dp = new int[n+2][n+2];
        int[] points = new int[n+2];
        points[0] = 1;
        points[n+1] = 1;

        for(int i=1; i<=n; i++){
            points[i]= nums[i-1];
        }


        for(int i=n; i>=0; i--){
            for(int j=i+1; j< n+2; j++){
                for(int k = i+1; k < j; k++)
                    dp[i][j] = Math.max(dp[i][j],
                            dp[k][j]+ points[k]*points[i]*points[j]+ dp[i][k]);
            }
        }
        return dp[0][n+1];
    }



}
