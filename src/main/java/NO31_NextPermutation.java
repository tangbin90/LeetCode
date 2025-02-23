/**
 * Created by tangbin1 on 2017/7/12.
 */
public class NO31_NextPermutation {
    public void nextPermutation(int[] nums) {
        if(nums==null || nums.length<=1)
            return;
        int length = nums.length;
        int i=length-2;

        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if(i>=0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            switchnum(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            switchnum(nums, i, j);
            i++;
            j--;
        }
    }
    public void switchnum(int[] nums, int pos1, int pos2){
        int temp=nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = temp;
    }

    public static void main(String... args){
        int[] nums={1,3,2};
        new NO31_NextPermutation().nextPermutation(nums);
        for(int num: nums)
        System.out.print(num+" ");
    }
}
