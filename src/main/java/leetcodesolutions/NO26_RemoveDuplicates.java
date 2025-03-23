package leetcodesolutions;

/**
 * Created by tangbin1 on 2017/7/5.
 */
public class NO26_RemoveDuplicates {
    public int removeDuplicates(int[] nums){
      if(nums==null||nums.length==0)
          return 0;
      int noneduplicate = 0;
      for(int loop=0;loop<nums.length;loop++){
          if(nums[loop]==nums[noneduplicate]){
              continue;
          }else{
              noneduplicate++;
              nums[noneduplicate]=nums[loop];
          }
      }
      return ++noneduplicate;
    }

    public static void main(String[] args){
        int[] nums = {1,1,1,1,2,2,2,2,3,3,3,3};
        NO26_RemoveDuplicates removeDuplicates = new NO26_RemoveDuplicates();
        removeDuplicates.removeDuplicates(nums);
        System.out.println(nums);
    }
}
