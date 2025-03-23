package leetcodesolutions; /**
 * Copyright (C), 2015-2018, 苏宁金融集团
 * Author: TangBin 17082720
 * FileName: NO47_PermutationsII
 * Date: 2018/3/8 11:07
 * Description:
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: TangBin 17082720 
 * @Email: 17082720@cnsuning.com
 * @create: 2018/3/8 11:07
 * @since 1.0.0
 * @description: 〈Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[
[1,1,2],
[1,2,1],
[2,1,1]
]〉
 */
public class NO47_PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums==null || nums.length==0) return res;
        boolean[] used = new boolean[nums.length];
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        dfs(nums, used, list, res);
        return res;
    }

    public void dfs(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res){
        if(list.size()==nums.length){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            if(i>0&&nums[i]==nums[i-1]&&!used[i-1]) continue;
            used[i]=true;
            list.add(nums[i]);
            dfs(nums,used,list,res);
            used[i]=false;
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> permuteUnique2(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if(nums==null||nums.length==0)
            return res;
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<>();
        permuteUniqueRe(nums,0,temp,res);
        return res;
    }

    public void permuteUniqueRe(int[] nums, int start, List<Integer> tempList,List<List<Integer>> res){
        if(start==nums.length)
            res.add(new ArrayList<>(tempList));

        for(int i=start;i<nums.length;i++){
            if(i+1<nums.length&&nums[i+1]==nums[i])
                continue;
            swap(nums,start, i);
            tempList.add(nums[start]);
            permuteUniqueRe(nums,start+1,tempList,res);
            swap(nums,start, i);
            tempList.remove(tempList.size()-1);
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,3};
        NO47_PermutationsII permutations = new NO47_PermutationsII();
        List<List<Integer>> res = permutations.permuteUnique(nums);
        for(List<Integer> aa : res){
            System.out.println(aa.toString());
        }
    }

}
