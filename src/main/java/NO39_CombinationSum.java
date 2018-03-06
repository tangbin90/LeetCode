import java.util.*;

/**
 * @author: 17082720 tangbin
 * @create: 2017/11/28 16:22
 * @description: Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7,
A solution set is:
[
[7],
[2, 2, 3]
]
 */
public class NO39_CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        Stack<Integer> path = new Stack<>();
        combinationSum(candidates,0,target,result,path,0);
        return result;
    }

    public void combinationSum(int[] candidates, int start,int target,List<List<Integer>> result,Stack<Integer> path,int sum){
        if(sum<target){
            int pre=-1;
            for(int i=start;i<candidates.length;i++){
                if(pre==candidates[i])
                    continue;
                path.push(candidates[i]);
                sum+=candidates[i];
                combinationSum(candidates,i,target,result,path,sum);
                sum-=candidates[i];
                path.pop();
                pre=candidates[i];
            }
        }else if(sum>target){
            return;
        }else{
            result.add((List)path.clone());
        }
    }

    public static void main(String[] args){
        int target = 50;
        int[] candidates = new int[]{2,2,3,4,5,1};
        NO39_CombinationSum combinationSumIns = new NO39_CombinationSum();
        List<List<Integer>> result =  combinationSumIns.combinationSum(candidates,target);
        System.out.println(result);
    }
}
