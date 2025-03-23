package leetcodesolutions;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author TangBin
 * @version V1.0
 * @date 21/03/2018 7:06 PM
 * Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],
1
\
2
/
3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?
 */
public class NO94_BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if(root==null)
            return res;
        return inorderTraversalRC(root);
    }

    public List<Integer> inorderTraversalRC(TreeNode root){

        List<Integer> li = new LinkedList<>();
        if(root.left!=null)
            li.addAll(inorderTraversalRC(root.left));
        li.add(root.val);
        if(root.right!=null)
            li.addAll(inorderTraversalRC(root.right));
        return li;
    }

    public List<Integer> inorderTraversalIter(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;

        while(cur!=null || !stack.empty()){
            while(cur!=null){
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }

        return list;
    }
}
