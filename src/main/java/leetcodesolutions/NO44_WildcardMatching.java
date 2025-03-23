package leetcodesolutions; /**
 * Copyright (C), 2015-2018, 苏宁金融集团
 * Author: TangBin 17082720
 * FileName: NO44_WildcardMatching
 * Date: 2018/3/7 15:32
 * Description:
 */

/**
 * @author: TangBin 17082720 
 * @Email: 17082720@cnsuning.com
 * @create: 2018/3/7 15:32
 * @since 1.0.0
 * @description: 〈'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true〉
 */
public class NO44_WildcardMatching {
    public boolean isMatchDP(String s,String p){
        char[] sChars = s.toCharArray();
        char[] pChars = p.toCharArray();
        boolean[][] mem = new boolean[sChars.length+1][pChars.length+1];
        mem[0][0] = true;

        for(int j=1;j<pChars.length+1;j++){
            if(pChars[j-1]=='*')
                mem[0][j] = true;
            else
                break;
        }

        for(int i=1;i<sChars.length+1;i++){
            for(int j=1;j<pChars.length+1;j++){
                if(pChars[j-1]=='*')
                    mem[i][j] = mem[i][j-1]||mem[i-1][j];
                else if(pChars[j-1]==sChars[i-1]||pChars[j-1]=='?')
                    mem[i][j] = mem[i-1][j-1];
                else
                    mem[i][j]=false;
            }
        }

        return mem[sChars.length][pChars.length];
    }
    public boolean isMatch(String s, String p) {
        char[] sChars = s.toCharArray();
        char[] pChars = p.toCharArray();
        return isMatch(sChars, 0, pChars,0);
    }

    public boolean isMatch(char[] s, int sIter, char[] p, int pIter){
        if(sIter==s.length&& pIter==p.length)
            return true;
        if(pIter==p.length)
            return false;
        if(p[pIter]=='*'){
            //当做空字符串处理
            boolean starAsNull=  isMatch(s,sIter,p,pIter+1);
            //当做单字符处理
            boolean startAsSingle = false;
            if(s.length-sIter>=pIter-p.length)
                startAsSingle = isMatch(s,sIter+1,p,pIter);
            return starAsNull||startAsSingle;
        }
        if(sIter<s.length&&pIter<p.length) {
            if (s[sIter] == p[pIter] || p[pIter] == '?'){
            }
                return isMatch(s, sIter + 1, p, pIter + 1);
        }
        return false;
    }


    public static void main(String[] args) {
        NO44_WildcardMatching wildcardMatching = new NO44_WildcardMatching();
        System.out.println(wildcardMatching.isMatchDP("aa","aa"));
    }
}
