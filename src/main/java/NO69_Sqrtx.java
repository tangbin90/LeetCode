/**
 * Copyright (C), 2015-2018, 苏宁金融集团
 * Author: TangBin 17082720
 * FileName: NO69_Sqrtx
 * Date: 2018/3/14 12:22
 * Description:
 */

/**
 * @author: TangBin 17082720 
 * @Email: 17082720@cnsuning.com
 * @create: 2018/3/14 12:22
 * @since 1.0.0
 * @description: 〈Implement int sqrt(int x).

Compute and return the square root of x.

x is guaranteed to be a non-negative integer.

〉
 */
public class NO69_Sqrtx {
    public int mySqrt(int x) {
        if(x<1)
            return 0;
        int begin = 1;
        int end = x;
        while(true){
            int mid = begin+(end-begin)/2;
            if(mid>x/mid){
                end = mid-1;
            }else {
                if(mid+1>x/(mid+1)){
                    return mid;
                }
                begin = mid+1;
            }
        }
    }

    public static void main(String[] args) {
        NO69_Sqrtx sqrtx = new NO69_Sqrtx();
        System.out.println(sqrtx.mySqrt(2147395599));
    }
}
