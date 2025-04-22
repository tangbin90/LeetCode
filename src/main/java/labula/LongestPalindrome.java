package labula;

public class LongestPalindrome {


    //dp[i][j] = func(s[i...j])
    //dp[i-1][j+1] = str
    public static int longestPalindrome(String str) {
        int[][] dp = new int[str.length()][str.length()];

        for(int i = 0; i < str.length(); i++){
            dp[i][i] = 1;
        }

        int n = str.length();
        for(int i = n-2; i >=0; i--){
            for( int j = i+1; j < n; j++){
                if(str.charAt(i) == str.charAt(j)){
                    dp[i][j] = dp[i+1][j-1] + 2;
                }else{
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);

                }
            }
        }
        return dp[0][n-1];
    }

    //dp[i][j] = func(s[i...j])
    //dp[i+1][j-1] = str
    //if str[i] == str[j] dp[i][j] = dp[i+1][j-1]
    //min(dp[i+1][j], dp[i][j-1]) + 1


    public static int formPalindrome(String str){
        int[][] dp = new int[str.length()][str.length()];
        for(int i=0; i<str.length(); i++){
            dp[i][i] = 0;
        }
        int n = str.length();
        for(int i=n-2; i >= 0; i-- ){
            for(int j= i+1; j < n; j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + 1;
                }
            }
        }

        return dp[0][n-1];
    }
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccba"));
    }

}
