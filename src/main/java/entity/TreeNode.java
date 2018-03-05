/**
 * Copyright (C), 2015-2017, 苏宁金融集团
 * Author: TangBin 17082720
 * FileName: TreeNode
 * Date: 2017/12/18 20:09
 * Description: tree node
 */
package entity;

/**
 * @author: TangBin 17082720 
 * @Email: 17082720@cnsuning.com
 * @create: 2017/12/18 20:09
 * @since 1.0.0
 * @description: 〈tree node〉
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }
    public String toString(){
        String ans = "";
        if(left!=null)
            ans+=left.toString();
        ans=ans+" "+val;
        if(right!=null)
            ans+=right.toString();
        return ans;
    }
}
