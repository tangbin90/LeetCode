/**
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
    public boolean isMatch(String s, String p) {
        char[] sChars = s.toCharArray();
        char[] pChars = p.toCharArray();
        boolean[][] hasCal = new boolean[s.length()+1][p.length()+1];
        boolean[][] mem =  new boolean[s.length()+1][p.length()+1];
        hasCal[0][0]=true;
        return isMatch(sChars, 0, pChars,0,mem,hasCal);
    }

    public void isMatch(char[] s, int sIter, char[] p, int pIter, boolean[][] mem,boolean[][] hasCal){
        hasCal[sIter][pIter]=true;
        if(p[pIter]=='*'){
            //当做空字符串处理
            boolean starAsNull=  isMatch(s,sIter,p,pIter+1);
            //当做单字符处理
            boolean startAsSingle = false;
            if(s.length-sIter>=pIter-p.length)
                if(hasCal[sIter+1][pIter])

                    else
                    startAsSingle = isMatch(s,sIter+1,p,pIter);
            mem[sIter][pIter] = starAsNull||startAsSingle;
        }
        if(sIter<s.length&&pIter<p.length) {
            if (s[sIter] == p[pIter] || p[pIter] == '?'){
                if(hasCal[sIter+1][pIter+1])
                    mem[sIter][pIter]=mem[sIter+1][pIter+1];
                else
                    isMatch(s, sIter + 1, p, pIter + 1,mem,hasCal);
            }
        }
        mem[sIter][pIter]=false;
    }


    public static void main(String[] args) {
        NO44_WildcardMatching wildcardMatching = new NO44_WildcardMatching();
        System.out.println(wildcardMatching.isMatch("abbabbbaabaaabbbbbabbabbabbbabbaaabbbababbabaaabbab","*aabcb***aa**a******aa*"));
    }
}
