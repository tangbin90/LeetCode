import entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author TangBin
 * @version V1.0
 * @date 31/03/2018 10:31 AM
 * Virtual User Accepted: 72
Virtual User Tried: 86
Virtual Total Accepted: 72
Virtual Total Submissions: 86
Difficulty: Medium
Given a binary tree, find the leftmost value in the last row of the tree.

Example 1:
Input:

2
/ \
1   3

Output:
1
Example 2:
Input:

1
/ \
2   3
/   / \
4   5   6
/
7

Output:
7
 */
public class NO513_FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> treeQueue = new LinkedList<>();
        if(root==null)
            return 0;

        treeQueue.offer(root);
        int bottomValue = root.val;
        while(!treeQueue.isEmpty()){
            int size = treeQueue.size();
            bottomValue = treeQueue.peek().val;
            for(int i=0;i<size;i++){
                TreeNode node = treeQueue.poll();
                if(node.left!=null)
                    treeQueue.offer(node.left);
                if(node.right!=null)
                    treeQueue.offer(node.right);
            }

        }
        return bottomValue;
    }
}
