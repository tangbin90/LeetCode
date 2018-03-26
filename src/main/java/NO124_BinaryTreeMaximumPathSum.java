import entity.TreeNode;

/**
 * @author TangBin
 * @version V1.0
 * @date 26/03/2018 3:38 PM
 */
public class NO124_BinaryTreeMaximumPathSum {
    private int maxNum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxpathSumRe(root);
        return maxNum;
    }

    private int maxpathSumRe(TreeNode root){
        if(root==null)
            return 0;
        int maxLeft = Math.max(0,maxpathSumRe(root.left));
        int maxRight = Math.max(0,maxpathSumRe(root.right));
        maxNum = Math.max(maxNum,maxLeft+maxRight+root.val);
        return Math.max(maxLeft+root.val,maxRight+root.val);
    }
}
