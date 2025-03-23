package leetcodesolutions; /**
 * Copyright (C), 2015-2018, 苏宁金融集团
 * Author: TangBin 17082720
 * FileName: NO43_Multiply_Strings
 * Date: 2018/3/7 9:57
 * Description:
 */

/**
 * @author: TangBin 17082720 
 * @Email: 17082720@cnsuning.com
 * @create: 2018/3/7 9:57
 * @since 1.0.0
 * @description: 〈Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.

Note:

The length of both num1 and num2 is < 110.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.〉
 */
public class NO43_Multiply_Strings {
    public String multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0"))
            return "0";
        char[] char1 = num1.toCharArray();
        char[] char2 = num2.toCharArray();
        int[] nums1 = new int[char1.length];
        int[] nums2 = new int[char2.length];
        int[] res = new int[char1.length+char2.length];
        char[] charRes = new char[char1.length+char2.length];
        for(int i=0;i<char1.length;i++){
            nums1[i] = char1[i]-'0';
        }

        for(int i=0;i<char2.length;i++){
            nums2[i] = char2[i]-'0';
        }

        for(int i=nums1.length-1;i>=0;i--){
            int calNum = nums1[i];
            int[] mulNums = new int[nums2.length+nums1.length];
            int carry = 0;
            for(int j=nums2.length-1;j>=0;j--){
                int temp = (calNum*nums2[j]+carry)%10;
                carry = (calNum*nums2[j]+carry)/10;
                mulNums[i+j+1] = temp;
            }
            mulNums[i] += carry;
            carry = 0;
            for(int k=mulNums.length-1;k>=0;k--){
                int temp= res[k]+mulNums[k]+carry;
                res[k] = temp%10;
                carry = temp/10;
            }
        }

        for(int i=0;i<charRes.length;i++){
            charRes[i] = (char)(res[i]+'0');
        }
        int j=0;
        for(;j<charRes.length;j++){
            if(charRes[j]!='0')
                break;
        }
        return String.valueOf(charRes).substring(j,charRes.length);
    }

    public static void main(String[] args){
        NO43_Multiply_Strings multiply_strings = new NO43_Multiply_Strings();
        System.out.println(multiply_strings.multiply("123","456"));
    }
}
