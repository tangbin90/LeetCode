package leetcodesolutions;

import entity.TreeNode;

/**
 * @author TangBin
 * @version V1.0
 * @date 23/03/2018 3:46 PM
 * Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:
2
/ \
1   3
Binary tree [2,1,3], return true.
Example 2:
1
/ \
2   3
Binary tree [1,2,3], return false.

 */
public class NO98_ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        Integer min = null;
        Integer max  = null;
        return isValidBSTRe(root, min, max);
    }

    private boolean isValidBSTRe(TreeNode root, Integer min, Integer max){
        if(root==null)
            return true;

        if(max!=null&&root.val>=max)
            return false;
        if(min!=null&& root.val<=min)
            return false;

        return isValidBSTRe(root.left,min, root.val)&&isValidBSTRe(root.right,root.val, max);
    }
}
