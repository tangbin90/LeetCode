import java.util.TreeMap;

/**
 * @author: 17082720 tangbin
 * @create: 2017/11/28 19:11
 * @description:
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums){
        int base = nums.length;
        int[] numstemp = new int[nums.length+1];
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0&&nums[i]<=nums.length)
                numstemp[nums[i]] = nums[i];
        }
        for(int i=1;i<numstemp.length;i++){
            if(numstemp[i]!=i)
                return i;
        }
        return numstemp.length;
    }


    public static void main(String[] args){
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        System.out.println( firstMissingPositive.firstMissingPositive(new int[]{3,4,-1,1}));
    }
}
