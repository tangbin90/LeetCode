package leetcodesolutions; /**
 * Copyright (C), 2015-2018, 苏宁金融集团
 * Author: TangBin 17082720
 * FileName: NO106_ConstructBinaryTreeFromInorderAndPostorderTraversal
 * Date: 2018/2/6 17:34
 * Description:
 */

import entity.TreeNode;

/**
 * @author: TangBin 17082720 
 * @Email: 17082720@cnsuning.com
 * @create: 2018/2/6 17:34
 * @since 1.0.0
 * @description: 〈〉
 * Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
preorder = [3,9,20,15,7]
Return the following binary tree:

  3
 / \
9  20
  /  \
15   7
 */
public class NO106_ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null|| postorder==null)
            return null;
        if(inorder.length!=postorder.length)
            return null;
        return buildTree(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }

    private TreeNode buildTree(int[] inorder,int inStart,int inEnd, int[] postorder, int postStart, int postEnd){
        if(inStart>inEnd||postStart>postEnd)
            return null;
        int head = postorder[postEnd];
        int index = -1;
        for(int i=inStart;i<=inEnd;i++){
            if(inorder[i]==head) {
                index = i;
                break;
            }
        }
        if(index==-1)
            return null;
        TreeNode headNode= new TreeNode(head);
        int rightnum = inEnd-index;
        headNode.left =  buildTree(inorder, inStart,index-1, postorder, postStart,  postEnd-1-rightnum);
        headNode.right= buildTree(inorder,index+1,inEnd,postorder,postEnd-rightnum,postEnd-1);
        return headNode;
    }


    public static void main(String[] args){
        int[] inorder = new int[]{9,3,15,20,7};
        int[] postorder = new int[]{9,15,7,20,3};
        NO106_ConstructBinaryTreeFromInorderAndPostorderTraversal reConstruct = new NO106_ConstructBinaryTreeFromInorderAndPostorderTraversal();
        TreeNode treeNode = reConstruct.buildTree(inorder,postorder);
        System.out.println(treeNode.toString());
    }

}
