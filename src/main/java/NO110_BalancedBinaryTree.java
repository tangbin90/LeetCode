import entity.TreeNode;

/**
 * @author TangBin
 * @version V1.0
 * @date 25/03/2018 10:11 PM
 *
 * Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example 1:

Given the following tree [3,9,20,null,null,15,7]:

3
/ \
9  20
/  \
15   7
Return true.

Example 2:

Given the following tree [1,2,2,3,3,null,null,4,4]:

1
/ \
2   2
/ \
3   3
/ \
4   4
Return false.


 */
public class NO110_BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;

        return level(root)!=-1;
    }


    private int level(TreeNode root){
        if(root==null)
            return 0;
        int leftLevel = level(root.left);
        if(leftLevel==-1)
            return -1;
        int rightLevel = level(root.right);
        if(rightLevel==-1)
            return -1;
        int diff = Math.abs(leftLevel-rightLevel);
        if(diff>1)
            return -1;
        else
            return 1+Math.max(level(root.left), level(root.right));
    }


}
