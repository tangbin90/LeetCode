package main.java;

/**
 * @author TangBin
 * @version V1.0
 * @date 28/11/2017 12:10 AM
 */
public class SearchInsert {
    public int searchInsert(int[] nums ,int target){
        int low = 0;
        int high=nums.length-1;
        int lastlow=low;
        int lasthigh=high;
        while (low <= high) {
            lasthigh=high;
            lastlow=low;
            int mid = (low + high) >> 1;
            if (nums[mid] < target) low = mid+1;
            else if (nums[mid] > target) high = mid-1;
            else return mid;

        }
        low=lastlow;
        high=lasthigh;
        if(nums[low]>=target)
            return low;
        if(nums[high]<=target)
            return high+1;
        return high;
    }

    public static void main(String... args){
        SearchInsert searchInsert = new SearchInsert();
        System.out.println(searchInsert.searchInsert(new int[]{1,3,5,6},2));

    }
}
