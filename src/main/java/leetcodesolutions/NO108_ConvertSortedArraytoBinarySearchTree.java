package leetcodesolutions;

import entity.TreeNode;

/**
 * @author TangBin
 * @version V1.0
 * @date 25/03/2018 9:46 PM
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.


Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

0
/ \
-3   9
/   /
-10  5
 */
public class NO108_ConvertSortedArraytoBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null||nums.length==0)
            return null;
        return sortedArrayToBST(0,nums.length-1, nums);
    }

    private TreeNode sortedArrayToBST(int start, int end, int[] nums){
        if(start>end)
            return null;
        if(start==end)
            return new TreeNode(nums[start]);

        int mid = start+(end-start)/2;
        TreeNode node  = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(start,mid-1,nums);
        node.right = sortedArrayToBST(mid+1,end,nums);
        return node;
    }
}
