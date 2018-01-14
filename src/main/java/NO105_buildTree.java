/**
 * Copyright (C), 2015-2017, 苏宁金融集团
 * Author: TangBin 17082720
 * FileName: NO105_buildTree
 * Date: 2017/12/18 20:08
 * Description: buildTree
 */

/**
 * @author: TangBin 17082720 
 * @Email: 17082720@cnsuning.com
 * @create: 2017/12/18 20:08
 * @since 1.0.0
 * @description: Given preorder and inorder traversal of a tree, construct the binary tree.
Note:
You may assume that duplicates do not exist in the tree.
 */

import entity.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class NO105_buildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0||inorder.length==0)
            return null;

        TreeNode treeNode = buildTree(preorder,0,inorder,0,inorder.length-1);
        return treeNode;
    }

    public TreeNode buildTree(int[] preorder,int preStart, int[] inOrder,int inStart, int inEnd){
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode tree  = new TreeNode(preorder[preStart]);
        int inIndex = 0; // Index of current root in inorder
        for(int i=inStart;i<=inEnd;i++){
            if(inOrder[i]==preorder[preStart]){
                inIndex=i;
            }
        }

        tree.left = buildTree(preorder, preStart+1, inOrder, inStart, inIndex-1);

        tree.right = buildTree(preorder, preStart+inIndex-inStart+1, inOrder, inIndex + 1, inEnd);

        return tree;
    }

    public static void main(String[] args) {
        int[] preOrder = {7,-10,-4,3,-1,2,-8,11};
        int[] inOrder = {7,-10,-4,3,-1,2,-8,11};
        TreeNode treeNode = new NO105_buildTree().buildTree(preOrder,inOrder);
        System.out.println(treeNode.toString());
    }
}
