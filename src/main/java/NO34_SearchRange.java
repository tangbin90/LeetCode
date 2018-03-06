/**
 * @author TangBin
 * @version V1.0
 * @date 27/11/2017 10:09 PM
 * @descriptrion
 *
 */
public class NO34_SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int pos = binarySearch(nums,0,nums.length-1,target);
        if(pos==-1)
            return new int[]{-1,-1};

        int high=pos;
        int low=pos;
        while(low>0){
            if(nums[low-1]==target)
                low--;
            else
                break;
        }
        while(high<nums.length-1){
            if(nums[high+1]==target)
                high++;
            else
                break;
        }

        return new int[]{low,high};

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

    public static void main(String... args){
        NO34_SearchRange searchRange = new NO34_SearchRange();
        int[] nums={1,2,3,3,3,3,3,4,4,5,6,6,7};
        int[] poss = searchRange.searchRange(nums,3);
        System.out.println(poss[0]+" "+poss[1]);
    }
}
