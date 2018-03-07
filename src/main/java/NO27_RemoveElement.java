/**
 * Created by tangbin1 on 2017/7/5.
 */
public class NO27_RemoveElement {
    public int removeElement(int[] nums, int val){
        if(nums==null||nums.length==0)
            return 0;
        int firstNotVal = -1;
        for(int pos=0;pos<nums.length;pos++){
            if(nums[pos]!=val) {
                firstNotVal++;
                int temp = nums[pos];
                nums[pos] = nums[firstNotVal];
                nums[firstNotVal] = temp;
            }
        }
        return ++firstNotVal;
    }


    public static void main(String[] args){
        NO27_RemoveElement removeElement = new NO27_RemoveElement();
        int[] nums={3,2,2,3};
        int length = removeElement.removeElement(nums,3);
        System.out.println(length);
    }
}
