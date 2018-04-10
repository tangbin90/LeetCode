import entity.ReverseNode;

/**
 * @author TangBin
 * @version V1.0
 * @date 31/03/2018 10:47 AM
 * Given an array nums, we call (i, j) an important reverse pair if i < j and nums[i] > 2*nums[j].

You need to return the number of important reverse pairs in the given array.

Example1:

Input: [1,3,2,3,1]
Output: 2
Example2:

Input: [2,4,3,5,1]
Output: 3
Note:
The length of the given array will not exceed 50,000.
All the numbers in the input array are in the range of 32-bit integer.
 */
public class NO493_ReversePairs_Merge {
    public int reversePairs(int[] nums) {
        return reversePairs(nums, 0, nums.length-1, 2);
    }

    private int reversePairs(int[] nums, int start ,int end, int L){
        if(start>=end)
            return 0;
        int mid = start+((end-start)>>1);
        int res = reversePairs(nums, start, mid, L )+reversePairs(nums, mid+1, end,  L);

        int i=start;
        int j = mid+1;
        int k=0;
        int reR = mid+1;
        int[] tempArray = new int[end-start+1];
        while(i<=mid){
            while(reR<=end&&nums[i]>nums[reR]*(long)L) reR++;
            res+=reR-(mid+1);
            while(j<=end&&nums[i]>nums[j]) tempArray[k++] =nums[j++];
            tempArray[k++] = nums[i++];
        }
        while(j<=end){
            tempArray[k++] = nums[j++];
        }
        System.arraycopy(tempArray,0,nums,start,end-start+1);
        return res;
    }

    public static void main(String[] args) {
        int[] nums =new int[]{1,3,2,3,1};
        NO493_ReversePairs_Merge merge = new NO493_ReversePairs_Merge();
        System.out.println(merge.reversePairs(nums));
    }
}
