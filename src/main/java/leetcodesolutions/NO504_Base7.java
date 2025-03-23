package leetcodesolutions;

/**
 * @author TangBin
 * @version V1.0
 * @date 31/03/2018 10:22 AM
 * Virtual User Accepted: 0
Virtual User Tried: 2
Virtual Total Accepted: 0
Virtual Total Submissions: 2
Difficulty: Easy
Given an integer, return its base 7 string representation.

Example 1:
Input: 100
Output: "202"
Example 2:
Input: -7
Output: "-10"
 */
public class NO504_Base7 {
    public String convertToBase7(int num) {
        StringBuilder sb = new StringBuilder();
        boolean isNegegive = false;
        if(num==0)
            return "0";
        if(num<0) {
            isNegegive =true;
            num = Math.abs(num);
        }
        while(num>0){
            int temp = num%7;
            sb.insert(0,temp);
            num = (num-temp)/7;
        }

        if(isNegegive)
            sb.insert(0,"-");
        return sb.toString();
    }

    public static void main(String[] args) {
        NO504_Base7 no504_base7 = new NO504_Base7();
        System.out.println(no504_base7.convertToBase7(-100));
    }
}
