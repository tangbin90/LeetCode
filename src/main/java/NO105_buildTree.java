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
        TreeNode tree  = new TreeNode(preorder[0]);
        int i=0;
        for( i=0;i<inorder.length;i++){
            if(preorder[0]==inorder[i])
                break;
        }
        tree.left = buildTree(preorder,1,inorder,0,i-1);
        tree.right = buildTree(preorder,1,inorder,i+1,inorder.length-1);
        return tree;
    }

    public TreeNode buildTree(int[] preOrder,int index, int[] inOrder,int start, int end){
        if(start==end)
            return new TreeNode(preOrder[index]);
        TreeNode tree  = new TreeNode(preOrder[index]);
        int i = start;
        for(;i<=end;i++){
            if(inOrder[i]==preOrder[index])
                break;
        }
        tree.left = buildTree(preOrder,index+1,inOrder,start,i-1);
        tree.right = buildTree(preOrder,index+1,inOrder,i+1,end);
        return tree;

    }
}
