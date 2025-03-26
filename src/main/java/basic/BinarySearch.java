package basic;

public class BinarySearch {
    //Binary search left
    public static int find(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;
        while(low <= high){
            int mid = low+(high-low)/2;
            if(nums[mid]< target){
                low = mid +1;
            }else if(nums[mid] > target){
                high = mid -1;
            } else {
                return mid;
            }

        }
        return -1;
    }

    public static int findLeft(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;
        while(low <= high){
            int mid = low+(high-low)/2;
            if(nums[mid]< target){
                low = mid +1;
            }else if(nums[mid] > target){
                high = mid -1;
            } else {
                high = mid -1;
            }

        }
        if(low >= nums.length)
            return -1;
        return low;
    }

    public static int findRight(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;
        while(low <= high){
            int mid = low+(high-low)/2;
            if(nums[mid]< target){
                low = mid +1;
            }else if(nums[mid] > target){
                high = mid -1;
            } else {
                low =  mid +1;
            }

        }

        return high;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,5,43,123,123};

        System.out.println(findRight(nums, 123));
    }
}
