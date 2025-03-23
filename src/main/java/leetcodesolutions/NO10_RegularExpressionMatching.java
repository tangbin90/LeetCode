package leetcodesolutions;

/**
 * @author TangBin
 * @version V1.0
 * @date 31/03/2017 3:46 PM
Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
 */

public class NO10_RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        boolean[][] dprecord = new boolean[s.length()+1][p.length()+1];
        int strlength=s.length();
        int patlength=p.length();
        dprecord[0][0]=true;
        for(int i=1;i<=p.length();i++){
            if(p.charAt(i-1)=='*'){
                if(i>1&&dprecord[0][i-2])
                    dprecord[0][i]=true;
            }
        }


        for(int i=0;i<strlength;i++){
            for(int j=0;j<patlength;j++){
                if(s.charAt(i)==p.charAt(j)||p.charAt(j)=='.')
                    dprecord[i+1][j+1]=dprecord[i][j];

                else if(p.charAt(j)=='*'){
                    if(j>0&&(p.charAt(j-1)!='.'&&p.charAt(j-1)!=s.charAt(i)))
                        dprecord[i+1][j+1] = dprecord[i+1][j-1];
                    else
                        dprecord[i+1][j+1]=dprecord[i+1][j]|dprecord[i+1][j-1]|dprecord[i][j+1];
                }
            }
        }
        return dprecord[strlength][patlength];
    }

    public static void main(String... args){
        NO10_RegularExpressionMatching rem = new NO10_RegularExpressionMatching();
        System.out.println(rem.isMatch("aaa","ab*ac*a"));
    }
}

