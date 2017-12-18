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
        lli.add(new LinkedList<>());
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

    public static void main(String[] args) {
        int[] nums = {1,1};
        NO90_SubsetsII subsets = new NO90_SubsetsII();
        System.out.println(subsets.subsetsWithDup(nums));
    }
}
