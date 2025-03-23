package leetcodesolutions;

import entity.TreeNode;

/**
 * @author TangBin
 * @version V1.0
 * @date 25/03/2018 11:21 PM
 * Given a binary tree, flatten it to a linked list in-place.

For example,
Given

1
/ \
2   5
/ \   \
3   4   6
The flattened tree should look like:
1
\
2
\
3
\
4
\
5
\
6
click to show hints.

Hints:
If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.
 */
public class NO114_FlattenBinaryTreetoLinkedList {
    private TreeNode prevNode = null;
    public void flatten(TreeNode root) {
        if(root==null)
            return;

        flatten(root.right);
        flatten(root.left);
        root.right = prevNode;
        root.left = null;
        prevNode = root;

    }
}
