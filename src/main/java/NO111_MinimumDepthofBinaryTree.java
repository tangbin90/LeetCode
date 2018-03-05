import entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author TangBin
 * @version V1.0
 * @date 05/03/2018 3:33 PM
 * @
 *
 */
public class NO111_MinimumDepthofBinaryTree {
    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);

        if(left==0 || right==0)
            return left+right+1;
        else
            return Math.min(right,left)+1;
    }


}
