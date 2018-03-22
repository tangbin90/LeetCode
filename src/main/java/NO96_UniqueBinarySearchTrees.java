import entity.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author TangBin
 * @version V1.0
 * @date 22/03/2018 2:35 PM
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

1         3     3      2      1
\       /     /      / \      \
3     2     1      1   3      2
/     /       \                 \
2     1         2                 3
 */
public class NO96_UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int [] G = new int[n+1];
        G[0] = G[1] = 1;

        for(int i=2; i<=n; ++i) {
            for(int j=1; j<=i; ++j) {
                G[i] += G[j-1] * G[i-j];
            }
        }

        return G[n];
    }

    public int generateTreesDP(int start, int end){
        if(start>end){
            return 1;
        }
        int count = 0;
        for(int i=start;i<=end;i++){
            int leftNum=generateTreesDP(start,i-1);
            int rightNum=generateTreesDP(i+1,end);
            count+=leftNum*rightNum;
        }
        return count;
    }

    public static void main(String[] args) {
        NO96_UniqueBinarySearchTrees uniqueBinarySearchTrees = new NO96_UniqueBinarySearchTrees();
        System.out.println(uniqueBinarySearchTrees.numTrees(3));
    }
}
