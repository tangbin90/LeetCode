/**
 * Copyright (C), 2015-2018, 苏宁金融集团
 * Author: TangBin 17082720
 * FileName: NO118_PascalsTriangle
 * Date: 2018/2/23 18:10
 * Description: Given numRows, generate the first numRows of Pascal's triangle.  For example, given numRows = 5, Return  [      [1],     [1,1],    [1,2,1],   [1,3,3,1],  [1,4,6,4,1] ]
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: TangBin 17082720 
 * @Email: 17082720@cnsuning.com
 * @create: 2018/2/23 18:10
 * @since 1.0.0
 * @description: 〈Given numRows, generate the first numRows of Pascal's triangle.  For example, given numRows = 5, Return  [      [1],     [1,1],    [1,2,1],   [1,3,3,1],  [1,4,6,4,1] ]〉
 */
public class NO118_PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new LinkedList<>();
        ArrayList<Integer> first = new ArrayList<>();
        if(numRows<=0)
            return result;
        first.add(1);
        result.add(first);
        if(numRows==1)
           return  result;

        ArrayList<Integer> lastArray= first;
        for(int i=2;i<=numRows;i++){
            ArrayList<Integer> array = new ArrayList<>();
            array.add(1);
            for(int j=0;j<lastArray.size()-1;j++){
                int num = lastArray.get(j)+lastArray.get(j+1);
                array.add(num);
            }
            array.add(1);
            result.add(array);
            lastArray = array;
        }
        return  result;
    }
}
