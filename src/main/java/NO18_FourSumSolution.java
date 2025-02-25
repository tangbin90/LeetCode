import java.util.*;

/**
 * Created by tangbin1 on 2017/6/29.
 */
public class NO18_FourSumSolution {
    public static List<List<Integer>> fourSum(int[] nums, int target){
        Arrays.sort(nums);
        Set<List<Integer>> fourSumList = new LinkedHashSet<>();
        for(int i=0;i<nums.length;i++){
            Set<List<Integer>> threeSumResult = threeSum(nums,i+1,nums.length,target-nums[i]);
            for(List<Integer> li : threeSumResult){
                li.add(nums[i]);
                fourSumList.add(li);
            }
        }
        List<List<Integer>> result = new LinkedList<>();
        for(List<Integer> li: fourSumList)
            result.add(li);
        return result;
    }


    public static Set<List<Integer>> threeSum(int[] nums, int start, int end, int target){
        Arrays.sort(nums);
        Set<List<Integer>> result = new LinkedHashSet<>();
        for(int i=start;i<end;i++){
            int head = i+1;
            int tail = end-1;
            int targetNum = target-nums[i];
            while(head<tail){
                if(nums[head]+nums[tail]<targetNum){
                    head++;
                }else if(nums[head]+nums[tail]>targetNum){
                    tail--;
                }else{
                    List<Integer> intPair = new ArrayList<>();
                    intPair.add(nums[i]);
                    intPair.add(nums[head]);
                    intPair.add(nums[tail]);
                    result.add(intPair);
                    head++;
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> twoSum(int[] nums, int target){
        HashMap<Integer, Integer> numMap = new HashMap<>();
        List<List<Integer>> listResult = new ArrayList<>() ;

        for(int i=0;i<nums.length;i++){
            numMap.put(nums[i], i);
            if(numMap.containsKey(target-nums[i])&&numMap.get(target-nums[i])<i){
                List<Integer> intlist = new ArrayList<>();
                intlist.add(nums[i]);
                intlist.add(target-nums[i]);
                listResult.add(intlist);
            }
        }
        return listResult;
    }

    public static void main(String... args){
        int[] nums={0,1,1,1,1,2,3,4,5,6,7};
        List<List<Integer>> lists = fourSum(nums, 5);
        for(List<Integer> ls:lists)
            System.out.println(ls);
    }
}
