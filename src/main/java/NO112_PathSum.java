import entity.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author TangBin
 * @version V1.0
 * @date 05/03/2018 4:43 PM
 */
public class NO112_PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new LinkedList<>();
        if(root==null)
            return list;
        List<Integer> listTemp = new LinkedList<Integer>();
        pathSumSearch(root, sum,list, listTemp);
        return list;

    }

    public void pathSumSearch(TreeNode root, int sum, List<List<Integer>> res,List<Integer> list){
        list.add(root.val);
        if(root.left==null&&root.right==null&&sum==root.val){
            res.add(new LinkedList<>(list));
            list.remove(list.size()-1);
            return;
        }
        if(root.left!=null)
            pathSumSearch(root.left,sum-root.val,res,list);
        if(root.right!=null)
            pathSumSearch(root.right,sum-root.val,res,list);

        list.remove(list.size()-1);

    }

}
