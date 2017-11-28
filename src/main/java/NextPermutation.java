/**
 * Created by tangbin1 on 2017/7/12.
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if(nums==null || nums.length<=1)
            return;
        int length = nums.length;
        int pos=0;
        int num = nums[0];

        for(int i=length-1;i>0;i--){
            if(nums[i-1]<nums[i]) {
                num = nums[i-1];
                pos=i-1;
                break;
            }
        }

        int posj = 0;
        for(int j=length-1;j>=0;j--)
            if(nums[j]>num) {
                posj = j;
                break;
            }
        switchnum(nums,pos,posj);
    }
    public void switchnum(int[] nums, int pos1, int pos2){
        int temp=nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = temp;
    }

    public static void main(String... args){
        int[] nums={1,2,3};
        new NextPermutation().nextPermutation(nums);
    }
}
