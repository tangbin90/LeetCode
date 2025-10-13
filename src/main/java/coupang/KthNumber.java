package coupang;

public class KthNumber {
    /**
     Given an integer array nums and an integer k, return the k-th largest element in the array.
     Note that you need to find the k-th largest element after sorting the array, not the k-th distinct element.
     You must design and implement an algorithm with O(n) time complexity to solve this problem.


     示例 1:

     输入: [3,2,1,5,6,2,7,2,6,4], k = 2
     输出: 5
     示例 2:

     输入: [3,2,3,1,2,4,5,5,6], k = 4
     输出: 4


     提示：
     1 <= k <= nums.length <= 105
     -104 <= nums[i] <= 104
     **/

    public int findKth(int k, int[] nums){
        if(nums.length == 0)
            return -1;
        return findKth(nums, k, 0, nums.length);
    }

    public int findKth(int[] nums, int k, int start, int end){
        if(k == 0 ){
            return nums[start];
        }

        int begin = start;

        int left = start + 1;
        int right = end -1;
        while(left < right){
            while(nums[left] < nums[start]){
                left++;
            }

            while(nums[right] > nums[start]){
                right--;
            }

            if(left < right) {
                swap(nums, left, right);
            } else{
                break;
            }
            left ++;
            right --;
        }
        swap(nums,left - 1, start);
        start = left - 1;


        if(end - start > k){
            return findKth(nums, k, start + 1, end);
        }else if(end - start < k){
            return findKth(nums, k - (end - start), begin, start);
        } else {
            return nums[start];
        }
    }

    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        KthNumber kthNumber = new KthNumber();
        int[] nums = {};
        System.out.println(kthNumber.findKth(4, nums));

    }

}
