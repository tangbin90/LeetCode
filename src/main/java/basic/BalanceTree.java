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

    public static boolean isInTree(TreeNode node, int target) {
        if(node == null)  return false;

        if(node.val == target)
            return true;

        if(node.val > target)
            return isInTree(node.left, target);

        return isInTree(node.right, target);

    }

    public static TreeNode insertIntoBST(TreeNode root, int val){
        if(root == null)
            return null;

        if(root.val > val ){
            if(root.left != null){
                insertIntoBST(root.left, val);
            } else {
                root.left = new TreeNode(val);
            }
        } else if(root.val < val){
             if(root.right != null){
                 insertIntoBST(root.right, val);
             } else {
                 root.right = new TreeNode(val);
             }
        }

        return root;
    }

    public static TreeNode deleteNode(TreeNode root, int key){
        if(root== null) return null;

        if(root.val== key){
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;
            TreeNode minNode = getMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, minNode.val);
        } else if(root.val > key){
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }

        return root;
    }

    public static TreeNode getMin(TreeNode node) {
        while(node.left != null) node = node.left;
        return node;
    }






}
