package leetcodesolutions;

/**
 * @author TangBin
 * @version V1.0
 * @date 05/12/2017 10:53 PM
 */
public class NO75_SortColors {
    public void sortColors(int[] nums) {
        int lastRed=-1;
        int lastBlue=nums.length;
        int iter=0;
        while(iter!=lastBlue){
            if(nums[iter]==0) {
                lastRed++;
                swap(nums,iter,lastRed);
                iter++;
            }else if(nums[iter]==2){
                lastBlue--;
                swap(nums,iter,lastBlue);
            }else
                iter++;

        }
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,1,2,0,1,0,2};
        new NO75_SortColors().sortColors(nums);
        System.out.println(nums);
    }
}
