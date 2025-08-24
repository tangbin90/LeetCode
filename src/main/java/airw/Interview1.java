package airw;

// n*n matrix
//[1,2,3]
//[0,1,3]
//[3,4,5]

public class Interview1 {
    public static String[][] paths = new String[][]{};

    public static int pickStones(int[][] stones){
        if(stones == null)
            return 0;
        int m = stones.length;
        if(m==0)
            return 0;
        int n = stones[0].length;
        if(n==0)
            return 0;

        int[][] dp = new int[m][n];
        dp[0][0] = stones[0][0];
        paths[0][0] = path(0,0);
        for(int i=1; i< m; i++){
            dp[i][0] = dp[i-1][0] + stones[i][0];
            paths[i][0] = paths[i-1][0] +"->"+ path(i,0);
        }
        for(int i=1; i< n; i++){
            dp[0][i] = dp[0][i-1] + stones[0][i];
            paths[0][i] = paths[0][i-1] + "->" + path(0,i);
        }

        //dp[i][j] = max(dp[i-1][j], dp[i][j-1]) + stones[i][j]
        //dp[m-1][n-1]

        for(int i=1; i < m; i++){
            for(int j=1; j <n; j++){
                if(dp[i-1][j] > dp[i][j-1]){
                    dp[i][j] =dp[i-1][j] + stones[i][j];
                    paths[i][j] = paths[i-1][j] + "->" + path(i, j);
                } else {
                    dp[i][j] =dp[i][j-1] + stones[i][j];
                    paths[i][j] = paths[i][j-1] + "->" + path(i, j);
                }
            }
        }

        return dp[m-1][n-1];
    }

    public static String path(int i, int j){
        return i+","+j;
    }

    public static void main(String[] args) {
        int[][] stones = new int[3][3];
        paths = new String[3][3];
        int[] a = new int[]{1,2,3};
        int[] b = new int[]{1,2,3};
        int[] c = new int[]{1,2,3};
        stones[0] = a;
        stones[1] = b;
        stones[2] = c;
        System.out.println(pickStones(stones));
        System.out.println(paths[2][2]);


    }

}
