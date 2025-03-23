package leetcodesolutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: TangBin 17082720 
 * @Email: 17082720@cnsuning.com
 * @create: 2017/12/18 15:37
 * @since 1.0.0
 * @description: Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,2], a solution is:

[
[2],
[1],
[1,2,2],
[2,2],
[1,2],
[]
]
 */
public class NO90_SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums.length==0) {
            return null;
        }
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> lli = new ArrayList<>();
        lli.add(new LinkedList<Integer>());
        List<Integer> dup = new LinkedList<>();
        List<List<Integer>> lliTemp = new ArrayList<>();
        int duplicate = Integer.MAX_VALUE;
        for(int i=0;i<len;i++){
            if(duplicate!=nums[i]){
                dup.clear();
                duplicate=nums[i];
                lli.addAll(lliTemp);
                lliTemp =  new ArrayList<>();
            }
            dup.add(nums[i]);
            for(List<Integer> tempLi : lli){
                List<Integer> addlli = new LinkedList<>();
                addlli.addAll(tempLi);
                addlli.addAll(dup);
                lliTemp.add(addlli);
            }

        }
        lli.addAll(lliTemp);
        return lli;
    }

    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> each = new ArrayList<>();
        helper(res, each, 0, nums);
        return res;
    }
    public void helper(List<List<Integer>> res, List<Integer> each, int pos, int[] n) {
        if (pos <= n.length) {
            res.add(each);
        }
        int i = pos;
        while (i < n.length) {
            each.add(n[i]);
            helper(res, new ArrayList<>(each), i + 1, n);
            each.remove(each.size() - 1);
            i++;
            while (i < n.length && n[i] == n[i - 1]) {i++;}
        }
        return;
    }

    public List<List<Integer>> subsetsWithDupIII(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        subsetsWithDupHelper(nums, 0, res, new ArrayList<>());
        return res;
    }

    private void subsetsWithDupHelper(int[] nums, int pos, List<List<Integer>> res, List<Integer> tmpRes) {
        // subset means it does not need contain all elements, so the condition is <= rather than ==
        // and do not return after this statement
        if(pos <= nums.length) res.add(new ArrayList<>(tmpRes));

        for(int i=pos; i<nums.length; i++) {
            // avoid duplicates
            if(i > pos && nums[i] == nums[i-1])
                continue;
            tmpRes.add(nums[i]);
            subsetsWithDupHelper(nums, i + 1, res, tmpRes);
            tmpRes.remove(tmpRes.size() - 1);
        }
    }
    public static void main(String[] args) {
        int[] nums = {1,1,1,2};
        NO90_SubsetsII subsets = new NO90_SubsetsII();
        System.out.println(subsets.subsetsWithDupIII(nums));
    }
}
