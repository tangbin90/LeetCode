package leetcodesolutions;

import entity.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author TangBin
 * @version V1.0
 * @date 31/03/2018 10:39 AM
 * You need to find the largest value in each row of a binary tree.

Example:
Input:

1
/ \
3   2
/ \   \
5   3   9

Output: [1, 3, 9]

 */
public class NO515_FindLargestValueinEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> treeQueue = new LinkedList<>();
        List<Integer> li = new LinkedList<>();
        if(root==null)
            return li;

        treeQueue.offer(root);
        int largest = Integer.MIN_VALUE;
        while(!treeQueue.isEmpty()){
            int size = treeQueue.size();
            for(int i=0;i<size;i++){
                TreeNode node = treeQueue.poll();
                if(node.val>largest)
                    largest= node.val;
                if(node.left!=null)
                    treeQueue.offer(node.left);
                if(node.right!=null)
                    treeQueue.offer(node.right);
            }
            li.add(largest);
            largest = Integer.MIN_VALUE;
        }
        return li;
    }
}
