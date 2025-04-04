package leetcodesolutions;

import entity.TreeLinkNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author TangBin
 * @version V1.0
 * @date 26/03/2018 3:04 PM
 * Given a binary tree

struct TreeLinkNode {
TreeLinkNode *left;
TreeLinkNode *right;
TreeLinkNode *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
1
/  \
2    3
/ \  / \
4  5  6  7
After calling your function, the tree should look like:
1 -> NULL
/  \
2 -> 3 -> NULL
/ \  / \
4->5->6->7 -> NULL
 */
public class NO116_PopulatingNextRightPointersinEachNode {
    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> queue = new LinkedList<>();
        if(root==null)
            return;
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeLinkNode node = queue.poll();
            int size = queue.size();
            if(node.left!=null)
                queue.offer(node.left);
            if(node.right!=null)
                queue.offer(node.right);
            for(int i=0;i<size;i++){
                node.next = queue.poll();
                node = node.next;
                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);

            }
            node.next = null;
        }
    }
}
