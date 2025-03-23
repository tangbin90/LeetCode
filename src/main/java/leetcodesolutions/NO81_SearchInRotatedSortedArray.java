package leetcodesolutions;

/**
 * @author: 17082720 tangbin
 * @create: 2017/12/7 17:02
 * @description:
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Write a function to determine if a given target is in the array.

The array may contain duplicates.


 */
public class NO81_SearchInRotatedSortedArray {
    public boolean search(int[] nums, int target) {
        if(nums.length==0)
            return false;
        int start = 0;
        int end = nums.length-1;
        while(start<end){
            int mid = (start+end)/2;
            if(nums[mid]==target)
                return true;
            if(nums[mid]>nums[end]){
                if(nums[mid]>target && nums[start] <= target) end = mid-1;
                else start = mid+1;
            }else if(nums[mid]<nums[end]){
                if(nums[mid]<target && target<=nums[end] ) start = mid+1;
                else end = mid-1;
            }else{
                end--;
            }
        }
        return nums[start]==target;
    }

    public static void main(String[] args) {
        int[] nums = {3,1};
        System.out.println(new NO81_SearchInRotatedSortedArray().search(nums,0));
    }
}
