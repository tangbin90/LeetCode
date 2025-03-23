package leetcodesolutions; /**
 * Copyright (C), 2015-2018, 苏宁金融集团
 * Author: TangBin 17082720
 * FileName: NO70_ClimbingStairs
 * Date: 2018/3/14 16:37
 * Description:
 */

/**
 * @author: TangBin 17082720 
 * @Email: 17082720@cnsuning.com
 * @create: 2018/3/14 16:37
 * @since 1.0.0
 * @description: 〈You are climbing a stair case. It takes n steps to reach to the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
Note: Given n will be a positive integer.
〉
 */
public class NO70_ClimbingStairs {
    public int climbStairs(int n) {
        if(n==1)
            return 1;
        if(n==2)
            return 2;
        int oneStep = 1;
        int twoStep = 2;
        for(int i=3;i<=n;i++){
            int temp = oneStep+twoStep;
            oneStep=twoStep;
            twoStep = temp;
        }
        return twoStep;
    }
}
