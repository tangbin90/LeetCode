/**
 * Copyright (C), 2015-2018, 苏宁金融集团
 * Author: TangBin 17082720
 * FileName: NO120_Triangle
 * Date: 2018/2/24 11:05
 * Description:
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author: TangBin 17082720 
 * @Email: 17082720@cnsuning.com
 * @create: 2018/2/24 11:05
 * @since 1.0.0
 * @description: 〈〉
 */
public class NO120_Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int rowNum = triangle.size();
        int[] calculatedNum = new int[rowNum];
        for(int i=0;i<rowNum;i++)
            calculatedNum[i]=0;
        return minimumTotalHelper(0,0,triangle);
    }

    public int minimumTotal2(List<List<Integer>> triangle){
        List<Integer> calculatedNum = triangle.get(triangle.size()-1);
        for(int i=triangle.size()-2;i>=0;i--){
            List<Integer> nums = triangle.get(i);
            for(int j=0;j<nums.size();j++){
                calculatedNum.set(j,Math.min(calculatedNum.get(j),calculatedNum.get(j+1))+nums.get(j));
            }
        }
        return calculatedNum.get(0);
    }

    private int minimumTotalHelper(int row,int col, List<List<Integer>> triangle){
        int rowNum = triangle.size();
        if(row==rowNum-1)
            return triangle.get(row).get(col);

        int num =  triangle.get(row).get(col);
        int minLeft = minimumTotalHelper(row+1,col,triangle);
        int minRight = minimumTotalHelper(row+1,col+1,triangle);
        num = Math.min(minLeft,minRight)+num;
        return num;
    }

    public static void main(String[] args){
        List<List<Integer>> ll = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        ll.add(l1);

        List<Integer> l2 = new ArrayList<>();
        l2.add(-5);
        l2.add(-2);
        ll.add(l2);

        List<Integer> l3 = new ArrayList<>();
        l3.add(3);
        l3.add(6);
        l3.add(1);
        ll.add(l3);

        List<Integer> l4 = new ArrayList<>();
        l4.add(-1);
        l4.add(2);
        l4.add(4);
        l4.add(-3);
        ll.add(l4);

        NO120_Triangle triangle = new NO120_Triangle();
        System.out.println( triangle.minimumTotal2(ll));

    }
}
