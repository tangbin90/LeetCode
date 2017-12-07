/**
 * @author: 17082720 tangbin
 * @create: 2017/12/7 10:42
 * @description:
 */
public class NO80_RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0)
            return 0;
        boolean sameNumCount = false;
        int preNum=nums[0];
        int lastpos = 0;
        for(int i=1;i<nums.length;i++){
            if(preNum==nums[i]) {
                if(!sameNumCount){
                    ++lastpos;
                    swap(nums,lastpos,i);
                }
                sameNumCount=true;
            } else{
                preNum = nums[i];
                sameNumCount=false;
                ++lastpos;
                swap(nums,lastpos,i);
            }

        }
        return ++lastpos;
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j]=temp;

    }
    public static void main(String[] args) {
        int[] nums = {1,1,1,2};
        NO80_RemoveDuplicatesFromSortedArrayII removeDuplicatesFromSortedArrayII = new NO80_RemoveDuplicatesFromSortedArrayII();
        int count = removeDuplicatesFromSortedArrayII.removeDuplicates(nums);
        System.out.println(count);
    }
}
