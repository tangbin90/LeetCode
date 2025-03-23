package leetcodesolutions;

import java.util.Arrays;

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
public class NO493_ReversePairs_BIT {
    public int reversePairs(int[] nums) {
        int res = 0;
        int[] copy = Arrays.copyOf(nums,nums.length);
        int[] bit = new int[copy.length+1];
        Arrays.sort(copy);

        for (int ele : nums) {
            res += search(bit, index(copy,2L * ele + 1));
            insert(bit, index(copy,ele));
        }

        return res;
    }

    private int search(int[] bit, int index){
        //求比如参大或者相等的所有数的个数，传入的是被搜索的数字排序后的位置
        int sum = 0;
        while(index<bit.length){
           sum+=bit[index];
           index += (-index)&index;
        }
        return sum;
    }

    private void insert(int[] bit, int index){
        while(index>0){
            bit[index]++;
            index-=(-index)&index;
        }
    }

    public int index(int[] nums, long val){
        int l = 0, r = nums.length - 1, m = 0;

        while (l <= r) {
            m = l + ((r - l) >> 1);

            if (nums[m] >= val) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return l + 1;
    }

    public static void main(String[] args) {
        NO493_ReversePairs_BIT reversePairs = new NO493_ReversePairs_BIT();
        int[] nums = new int[]{1,1,2,2,2,2};
        System.out.println(reversePairs.index(nums, 2));
    }


}
