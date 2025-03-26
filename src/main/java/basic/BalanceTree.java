package basic;

import entity.TreeNode;

//二叉搜索树 search tree
public class BalanceTree {
    public static void plusone(TreeNode root){
        if(root == null)
            return;

        root.val += 1;
        plusone(root.left);
        plusone(root.right);
    }

    public static boolean isSameTree(TreeNode root1, TreeNode root2){
        if(root2 == null && root1 == null) return true;
        if(root2 == null || root1 == null) return false;

        if(root1.val !=root2.val )
            return false;

        return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
    }

    public static boolean isValidTree(TreeNode root, TreeNode min, TreeNode max){
        if( root ==null)
            return true;

        if(min != null && min.val >= root.val) return false;
        if(max != null && max.val <= root.val) return false;

        return isValidTree(root.right, root, max) && isValidTree(root.left, min, root);

    }
}
