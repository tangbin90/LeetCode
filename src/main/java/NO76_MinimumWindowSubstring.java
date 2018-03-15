/**
 * Copyright (C), 2015-2018, 苏宁金融集团
 * Author: TangBin 17082720
 * FileName: NO76_MinimumWindowSubstring
 * Date: 2018/3/15 10:48
 * Description:
 */

import java.util.*;

/**
 * @author: TangBin 17082720 
 * @Email: 17082720@cnsuning.com
 * @create: 2018/3/15 10:48
 * @since 1.0.0
 * @description: 〈Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the empty string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.〉
 */
public class NO76_MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        char[] chars =t.toCharArray();
        char[] sChars = s.toCharArray();
        Map<Character,Integer> charMap = new HashMap<>();

        for(int i=0;i<t.length();i++){
            if(charMap.containsKey(chars[i])){
                charMap.put(chars[i],charMap.get(chars[i])+1);
            }else{
                charMap.put(chars[i],1);
            }
        }
        int left = 0;
        int minLeft = 0;
        int right=0;
        int count=0;
        int minLength = s.length()+1;
        for(;right<sChars.length;right++){
            if(charMap.containsKey(sChars[right])){
                charMap.put(sChars[right],charMap.get(sChars[right])-1);
                if(charMap.get(sChars[right])>=0)
                    count++;
            }
            while(count==chars.length){
                int length = right-left+1;
                if(length<minLength) {
                    minLeft = left;
                    minLength = length;
                }
                if(charMap.containsKey(sChars[left])) {
                    charMap.put(sChars[left],charMap.get(sChars[left])+1);
                    if(charMap.get(sChars[left])>0) {
                        count--;
                    }
                }
                left++;
            }
        }
        if(minLength>s.length()){
            return "";
        }
        return s.substring(minLeft,minLength+minLeft);
    }


    public static void main(String[] args) {
        NO76_MinimumWindowSubstring minimumWindowSubstring = new NO76_MinimumWindowSubstring();
        System.out.println(minimumWindowSubstring.minWindow("starasdfaxd","sfx"));
    }
}
