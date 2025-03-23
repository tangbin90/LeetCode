package leetcodesolutions;

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
public class NO493_ReversePairs_BST {
    public int reversePairs(int[] nums) {
        int res = 0;
        ReverseNode root = null;

        for (int ele : nums) {
            res += search(root, 2L * ele + 1);
            root = insert(root, ele);
        }

        return res;
    }

    private int search(ReverseNode root, long val){
        if(root==null)
            return 0;
        if(val==root.val)
            return root.cnt;
        if(val < root.val)
            return root.cnt+search(root.left, val);
        return search(root.right, val);
    }

    private ReverseNode insert(ReverseNode root, int val){
        if(root==null)
            return new ReverseNode(val);
        if(val==root.val){
            root.cnt++;
            return root;
        }else if(val>root.val) {
            root.cnt++;
            return insert(root.right, val);
        }else
            return insert(root.left, val);
    }

}
