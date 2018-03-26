/**
 * @author TangBin
 * @version V1.0
 * @date 26/03/2018 1:59 PM
 * Given a string S and a string T, count the number of distinct subsequences of S which equals T.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.


 */
public class NO115_DistinctSubsequences {
    public int numDistinctMem(String s, String t) {
        int[][] mem = new int[t.length()+1][s.length()+1];

        mem[0][0] = 1;
        for(int i=1;i<=s.length();i++){
            mem[0][i] = 1;
        }

        for(int j=1;j<=t.length();j++){
            mem[j][0] = 0;
        }

        for(int i=1;i<=t.length();i++) {
            for (int j = 1; j <= s.length(); j++) {
                if(t.charAt(i-1)==s.charAt(j-1))
                    mem[i][j] = mem[i-1][j-1]+mem[i][j-1];
                else
                    mem[i][j] = mem[i][j-1];
            }
        }

        return mem[t.length()][s.length()];
    }

    public int numDistinct(String s, String t) {
         return numDistinct(s,0, t, 0);
    }

    private int  numDistinct(String s, int sPos, String t, int tPos){
        int count=0;
        if(sPos==s.length()&& tPos==t.length())
            return 1;
        if(tPos==t.length())
            return 1;
        if(sPos == s.length())
            return 0;

        for(int i = sPos;i<s.length();i++){
            if(s.charAt(i)==t.charAt(tPos)){
                count+= numDistinct(s, i+1, t, tPos+1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NO115_DistinctSubsequences distinctSubsequences = new NO115_DistinctSubsequences();
        System.out.println(distinctSubsequences.numDistinctMem("ddd","dd"));
    }
}
