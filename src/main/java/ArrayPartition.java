public class ArrayPartition {

    //dp[i][j] = x for i object when capacity is j if x is true then we can fill the pack
    boolean canPartition(int[] nums){
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
        }

        if(sum % 2 ==1)
            return false;

        boolean[][] dp = new boolean[nums.length][sum/2+1];

        boolean result = false;

        for(int i=0; i< nums.length-1; i++)
            result =  result || dp[i][sum/2];

        for(int i=0; i< nums.length; i++)
            dp[i][0] = true;
        for(int i=0; i< sum/2+1; i++)
            dp[0][i] = false;


        for(int i=1; i <= nums.length; i++){
            for(int j=1; j<=sum/2; j++){
                if(j - nums[i-1] <0){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }

            }
        }
        //dp[i][j] dp[i]
        return dp[nums.length][sum/2+1];



    }
}
