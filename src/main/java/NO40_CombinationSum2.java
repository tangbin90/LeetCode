import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author: 17082720 tangbin
 * @create: 2017/11/28 18:07
 * @description:
 */
public class NO40_CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        Stack<Integer> path = new Stack<>();
        combinationSum2(candidates,0,target,result,path,0);
        return result;
    }

    public void combinationSum2(int[] candidates, int start,int target,List<List<Integer>> result,Stack<Integer> path,int sum){
        if(sum<target){
            int pre = -1;
            for(int i=start;i<candidates.length;i++){
                if(pre==candidates[i])
                    continue;
                path.push(candidates[i]);
                sum+=candidates[i];
                combinationSum2(candidates,i+1,target,result,path,sum);
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
        int target = 8;
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        NO40_CombinationSum2 combinationSumIns = new NO40_CombinationSum2();
        List<List<Integer>> result =  combinationSumIns.combinationSum2(candidates,target);
        System.out.println(result);
    }
}
