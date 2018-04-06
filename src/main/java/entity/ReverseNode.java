package entity;

/**
 * @author TangBin
 * @version V1.0
 * @date 05/04/2018 11:57 AM
 */
public class ReverseNode{
    public int val;
    public int cnt;
    public ReverseNode left;
    public ReverseNode right;

    public ReverseNode(int val){
        this.val = val;
        this.cnt = 1;
    }

}
