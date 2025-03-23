package leetcodesolutions;

import entity.TreeLinkNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author TangBin
 * @version V1.0
 * @date 26/03/2018 3:19 PM
 */
public class NO117_PopulatingNextRightPointersinEachNodeII {
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
