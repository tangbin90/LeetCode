/**
 * Copyright (C), 2015-2018, 苏宁金融集团
 * Author: TangBin 17082720
 * FileName: NO46_Permutations
 * Date: 2018/3/8 10:21
 * Description:
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: TangBin 17082720 
 * @Email: 17082720@cnsuning.com
 * @create: 2018/3/8 10:21
 * @since 1.0.0
 * @description: 〈Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
[1,2,3],
[1,3,2],
[2,1,3],
[2,3,1],
[3,1,2],
[3,2,1]
]〉
 */
public class NO46_Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();

        if(nums==null||nums.length==0)
            return res;

        permute(nums,new LinkedList<>(),0,res);
        return res;
    }

    private void permute(int[] nums, List<Integer> numPer,int start, List<List<Integer>> res){
        if(start==nums.length){
            res.add(new ArrayList<Integer>(numPer));
        }
        for(int i=start;i<nums.length;i++){
            swap(nums,start, i);
            numPer.add(nums[start]);
            permute(nums,numPer,start+1,res);
            swap(nums,start, i);
            numPer.remove(numPer.size()-1);
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        NO46_Permutations permutations = new NO46_Permutations();
        List<List<Integer>> res = permutations.permute(nums);
        for(List aa : res){
            System.out.println(aa.toString());
        }
    }
}
