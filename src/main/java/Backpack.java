public class Backpack {
    //backpack can hold W weight
    //N things, wt[i] val[i]
    //most value

    //dp[i][w] weight, i things and value
    //dp[n][w]
    //dp[0][w] = 0 dp[i][0] = 0
    //dp[i][w]  no wt[i] dp[i][w] = dp[i-1][w] else dp[i][w - wt[i]] + val[i]

    public static int backpack(int[] wt, int[] val, int w){
        int n = wt.length;

        int[][] bp = new int[n+1][w+1];
        for(int i=0; i < w+1; i++){
            bp[0][i] = 0;
        }

        for(int i=0; i < n+1; i++){
            bp[i][0] = 0;
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=w; j++){
                if(w-wt[i] < 0)
                    bp[i][j] = bp[i-1][j];
                else {
                    bp[i][j] = Math.max(bp[i-1][j], bp[i-1][j-wt[i]]+val[i]);
                }

            }

        }
        return bp[n][w];
    }
}
