/**
 * Copyright (C), 2015-2018, 苏宁金融集团
 * Author: TangBin 17082720
 * FileName: NO58_LengthofLastWord
 * Date: 2018/3/9 17:46
 * Description:
 */

/**
 * @author: TangBin 17082720 
 * @Email: 17082720@cnsuning.com
 * @create: 2018/3/9 17:46
 * @since 1.0.0
 * @description: 〈
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

Example:

Input: "Hello World"
Output: 5〉
 */
public class NO58_LengthofLastWord {
    public int lengthOfLastWord(String s) {
        if(s==null||s.length()==0)
            return 0;
        int end = s.length();
        int begin = 1;
        char[] chars = s.toCharArray();
        for(int i=s.length()-1;i>=0;i--){
            if(chars[i]!=' '){
                end = i;
                break;
            }
        }
        for(int i=end-1;i>=0;i--) {
            if (chars[i] == ' ' ) {
                begin = i;
                break;
            }
        }
        return end-begin;
    }

    public static void main(String[] args) {
        NO58_LengthofLastWord lengthofLastWord = new NO58_LengthofLastWord()
    }
}
