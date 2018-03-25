import entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author TangBin
 * @version V1.0
 * @date 24/03/2018 8:41 AM
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
3
/ \
9  20
/  \
15   7
return its zigzag level order traversal as:
[
[3],
[20,9],
[15,7]
]

 */
public class NO103_BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        List<List<Integer>> lli = new LinkedList<>();
        int level = 0;
        if(root==null)
            return lli;
        queue1.offer(root);
        List<Integer> li = new LinkedList<>();
        while(!queue1.isEmpty()){
            TreeNode node = queue1.poll();
            if(level%2==0)
                li.add(node.val);
            else
                li.add(0,node.val);
            if(node.left!=null)
                queue2.offer(node.left);
            if(node.right!=null)
                queue2.offer(node.right);

            if(queue1.isEmpty()){
                level++;
                lli.add(new ArrayList<Integer>(li));
                li.clear();
                Queue<TreeNode> temp = queue1;
                queue1 = queue2;
                queue2 = temp;
            }
        }
        return lli;

    }
}
