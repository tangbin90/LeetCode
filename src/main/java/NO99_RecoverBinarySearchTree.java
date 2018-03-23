import apple.laf.JRSUIUtils;
import entity.TreeNode;

/**
 * @author TangBin
 * @version V1.0
 * @date 23/03/2018 3:57 PM
 * Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?

 */
public class NO99_RecoverBinarySearchTree {
    private TreeNode firstElement = null;
    private TreeNode secondElement = null;
    private TreeNode preTreeNode = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        traverse(root);

        int temp = firstElement.val;
        firstElement.val= secondElement.val;
        secondElement.val = temp;
    }

    private void traverse(TreeNode root){
        if(root==null)
            return;

        traverse(root.left);

        if(firstElement==null&&preTreeNode.val>=root.val){
            firstElement = preTreeNode;
        }

        if(firstElement!=null&&preTreeNode.val>=root.val){
            secondElement = root;
        }

        preTreeNode = root;
        traverse(root.right);
    }
}
