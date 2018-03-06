/**
 * @author TangBin
 * @version V1.0
 * @date 27/11/2017 9:38 PM
 */
public class NO33_SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if(nums.length==0)
            return -1;
        int low = 0;
        int high = nums.length-1;
        while(high>low){
            int mid=(high+low)>>1;
            if(nums[mid]>nums[high])low=mid+1;
            else high=mid;
        }
        int num1= binarySearch(nums,0,high>0?high-1:0,target);
        int num2=binarySearch(nums,high,nums.length-1,target);

        return num1==-1?num2:num1;
    }

    public int binarySearch(int[] nums,int low, int high, int target){
        while(low<=high){
            int mid=(low+high)>>1;
            if(nums[mid]<target) low=mid+1;
            else if(nums[mid]>target) high=mid-1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args){
        NO33_SearchInRotatedSortedArray searchInRotatedSortedArray = new NO33_SearchInRotatedSortedArray();
        int[] nums = {4,5,6,7,0,1,2,3};
        int pos = searchInRotatedSortedArray.search(nums,7);
        System.out.println(pos);
    }
}
