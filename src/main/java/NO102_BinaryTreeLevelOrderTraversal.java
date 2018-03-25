import entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author TangBin
 * @version V1.0
 * @date 23/03/2018 11:39 PM
 */
public class NO102_BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        List<List<Integer>> lli = new LinkedList<>();
        if(root==null)
            return lli;
        queue1.offer(root);
        List<Integer> li = new LinkedList<>();
        while(!queue1.isEmpty()){
            TreeNode node = queue1.poll();
            li.add(node.val);
            if(node.left!=null)
                queue2.offer(node.left);
            if(node.right!=null)
                queue2.offer(node.right);

            if(queue1.isEmpty()){
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
