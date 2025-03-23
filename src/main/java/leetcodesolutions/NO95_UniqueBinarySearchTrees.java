package leetcodesolutions;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author TangBin
 * @version V1.0
 * @date 22/03/2018 10:17 AM
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

1         3     3      2      1
\       /     /      / \      \
3     2     1      1   3      2
/     /       \                 \
2     1         2                 3
 */
public class NO95_UniqueBinarySearchTrees {
    public List<TreeNode> generateTrees(int n) {
        if(n==0)
            return new ArrayList<>();
        return generateTreesDP(1,n);

    }

    public List<TreeNode> generateTreesDP(int start,int end){
        List<TreeNode> lt = new LinkedList<>();
        if(start>end){
            lt.add(null);
            return lt;
        }

        for(int i=start;i<=end;i++){
            List<TreeNode> leftSubTrees=generateTreesDP(start,i-1);
            List<TreeNode> rightSubTrees=generateTreesDP(i+1,end);

            for(TreeNode leftSubTree:leftSubTrees){
                for(TreeNode rightSubTree:rightSubTrees){
                    TreeNode root=new TreeNode(i);
                    root.left=leftSubTree;
                    root.right=rightSubTree;
                    lt.add(root);
                }
            }
        }
        return lt;

    }
}
