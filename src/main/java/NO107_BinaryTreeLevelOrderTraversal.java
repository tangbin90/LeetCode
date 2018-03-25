import entity.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author TangBin
 * @version V1.0
 * @date 25/03/2018 5:48 PM
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
3
/ \
9  20
/  \
15   7
return its bottom-up level order traversal as:
[
[15,7],
[9,20],
[3]
]

 */
public class NO107_BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lli = new LinkedList<>();
        Queue<TreeNode> qi = new LinkedList<>();
        if(root==null)
            return lli;

        qi.offer(root);
        while(!qi.isEmpty()){
            int levelSize = qi.size();
            List<Integer> li = new LinkedList<>();
            for(int i=0;i<levelSize;i++){
                TreeNode node = qi.poll();
                if(node.left!=null)
                    qi.offer(node.left);
                if(node.right!=null)
                    qi.offer(node.right);
                li.add(node.val);
            }
            lli.add(0,li);
        }
        return lli;

    }
}
