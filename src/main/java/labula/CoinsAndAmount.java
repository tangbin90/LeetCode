package labula;

public class CoinsAndAmount {
    //dp[i][j] coins[i] coin value, j amount, how many ways
    public static int change(int amount, int[] coins){
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];

        for(int i=0; i<=n; i ++){
            dp[i][0] = 1;
        }

        for(int i=0; i<=amount; i++){
            dp[0][i] = 0;
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=amount ; j++){
                if(j >= coins[i-1]){
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }

        }

        return dp[n][amount];


    }
}
