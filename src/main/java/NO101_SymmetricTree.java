import entity.TreeNode;

/**
 * @author TangBin
 * @version V1.0
 * @date 23/03/2018 11:14 PM
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

1
/ \
2   2
/ \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
1
/ \
2   2
\   \
3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
 */
public class NO101_SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;

        return isSymmetric(root.left,root.right);

    }

    private boolean isSymmetric(TreeNode treeNode1, TreeNode treeNode2){
        if(treeNode1==null && treeNode2==null)
            return true;

        if(treeNode1==null || treeNode2==null)
            return false;

        if(treeNode1.val ==treeNode2.val)
            return isSymmetric(treeNode1.left,treeNode2.right) && isSymmetric(treeNode1.right, treeNode2.left);
        else
            return false;
    }


}
