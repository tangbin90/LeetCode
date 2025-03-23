package leetcodesolutions;

import entity.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class NO112_2MinimumTree {

    public int minDepth(TreeNode root) {
        Queue<TreeNode> nodeQueues = new LinkedList<TreeNode>();
         Set<TreeNode> visited = new HashSet<>();
        if(root==null)
            return 0;

        int depth = 1;
        nodeQueues.offer(root);
        while(!nodeQueues.isEmpty()){
            for(int i = 0; i < nodeQueues.size(); i++){
                TreeNode node = nodeQueues.poll();
                if(node.left == null && node.right == null){
                    return depth;
                }
                if(node.left != null){
                    nodeQueues.offer(node.left);
                }

                if(node.right != null) {
                    nodeQueues.offer(node.right);
                }
            }
            depth ++;
        }
        return depth;
    }
}
