package leetcodesolutions; /**
 * Copyright (C), 2015-2018, 苏宁金融集团
 * Author: TangBin 17082720
 * FileName: NO50_PowXN
 * Date: 2018/3/9 15:24
 * Description:
 */

/**
 * @author: TangBin 17082720 
 * @Email: 17082720@cnsuning.com
 * @create: 2018/3/9 15:24
 * @since 1.0.0
 * @description: 〈〉
 */
public class NO50_PowXN {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        if( x==1.0||x==0 ) return x;
        if(n == Integer.MIN_VALUE){
            if (x > 0)
                return 0;
            if (x < 0)
                return 1;
        }
        if(n < 0) {
            n = -n;
            x = 1/x;
        }

        return (n%2 == 0) ? myPow(x * x, n/2) : x *  myPow(x * x, n/2);
    }

    public double myPow2(double x, int n) {
        if (x == 0) {
            return 0D;
        }

        double result = 1;
        while (n != 0) {
            if ((n & 1) == 1) {
                if (n > 0) {
                    result *= x;
                } else {
                    result /= x;
                }
            }
            x *= x;
            n /= 2;
        }

        return result;
    }

}
