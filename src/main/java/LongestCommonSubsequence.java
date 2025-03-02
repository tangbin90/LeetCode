public class LongestCommonSubsequence {
    public static int longestCS(String s1, String s2){
        return dp(s1.length()-1, s2.length()-1, s1, s2);

    }

    public static int dp(int i, int j, String s1, String s2){
        if(i == -1 || j == -1)
            return 0;
        if(s1.charAt(i) == s2.charAt(j)){
            return dp(i-1, j-1, s1, s2) +1;
        } else {
            return Math.max(dp(i-1, j, s1, s2), dp(i, j-1, s1, s2));
        }

    }

    public static void main(String[] args) {
        System.out.println(longestCS("abcd", "abc"));
    }
}
