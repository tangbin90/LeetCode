/**
 * Copyright (C), 2015-2018, 苏宁金融集团
 * Author: TangBin 17082720
 * FileName: NO77_Combinations
 * Date: 2018/3/15 15:54
 * Description:
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author: TangBin 17082720 
 * @Email: 17082720@cnsuning.com
 * @create: 2018/3/15 15:54
 * @since 1.0.0
 * @description: 〈Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
[2,4],
[3,4],
[2,3],
[1,2],
[1,3],
[1,4],
]〉
 */
public class NO77_Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combs = new ArrayList<>();
        combine(combs, new ArrayList<Integer>(), 1, n, k);
        return combs;
    }

    private void combine(List<List<Integer>> combs, List<Integer> li, int start, int n, int k){
        if(k==0) {
            combs.add(new ArrayList<>(li));
            return;
        }
        for(int i=start; i<=n;i++){
            li.add(i);
            combine(combs,li,i+1,n,k-1);
            li.remove(li.size()-1);
        }
    }


    public static void main(String[] args) {
        NO77_Combinations combinations = new NO77_Combinations();
        List<List<Integer>> lls = combinations.combine(2,2);
        for(List<Integer> ls : lls){
            System.out.println(ls.toString());
        }

    }


}
