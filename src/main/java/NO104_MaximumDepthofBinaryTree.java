import entity.TreeNode;

/**
 * @author TangBin
 * @version V1.0
 * @date 25/03/2018 12:00 AM
 * Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

For example:
Given binary tree [3,9,20,null,null,15,7],

3
/ \
9  20
/  \
15   7
return its depth = 3.


 */
public class NO104_MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));

    }
}
