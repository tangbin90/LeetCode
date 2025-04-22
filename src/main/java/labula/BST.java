package labula;

import entity.TreeNode;

public class BST {
    boolean isValidBST(TreeNode root, TreeNode min, TreeNode max){
        if(root == null) return true;

        if(min !=null && root.val < min.val) return false;
        if(max != null && root.val > max.val) return false;

        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    boolean isInBST(TreeNode root, int target){
        if(root == null) return false;
        if(root.val == target) return true;

        if(root.val < target)
            return isInBST(root.right, target);

        return isInBST(root.left, target);
    }

    public TreeNode insertIntoBST(TreeNode root, int val){
        if(root == null) return new TreeNode(val);

        if(root.val == val)
            return root;
        if(root.val > val)
            root.left = insertIntoBST(root.left, val);

        if(root.val < val)
            root.right = insertIntoBST(root.right, val);

        return root;
    }

    TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return null;

        if(root.val == key){
            if(root.left == null && root.right == null)
                return null;

            if(root.left == null)
                return root.right;

            if(root.right == null)
                return root.left;


            TreeNode minNode = getMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, minNode.val);
        }

        if(root.val > key){
            root.left = deleteNode(root.left, key);
        }

        if(root.val < key){
            root.right = deleteNode(root.right, key);
        }

        return root;

    }

    TreeNode getMin(TreeNode node){
        while(node.left != null) node = node.left;
        return node;
    }
}
