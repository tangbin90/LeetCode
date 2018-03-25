import entity.TreeNode;

/**
 * @author TangBin
 * @version V1.0
 * @date 25/03/2018 11:52 PM
 */
public class NO112_PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;

        if(root.left == null && root.right == null) return sum == root.val;

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

}
