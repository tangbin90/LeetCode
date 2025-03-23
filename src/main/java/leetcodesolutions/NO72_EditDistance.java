package leetcodesolutions; /**
 * Copyright (C), 2015-2018, 苏宁金融集团
 * Author: TangBin 17082720
 * FileName: NO72_EditDistance
 * Date: 2018/3/14 17:47
 * Description:
 */

/**
 * @author: TangBin 17082720 
 * @Email: 17082720@cnsuning.com
 * @create: 2018/3/14 17:47
 * @since 1.0.0
 * @description: 〈Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character〉
 */
public class NO72_EditDistance {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();

        int[][] mem = new int[l1+1][l2+1];

        for(int i=0;i<=l1;i++){
            mem[i][0] = i;
        }

        for(int j=0;j<=l2;j++){
            mem[0][j] = j;
        }

        for(int i=1;i<=l1;i++){
            for(int j=1;j<=l2;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1))
                    mem[i][j] = mem[i-1][j-1];
                else
                    mem[i][j] = Math.min(Math.min(mem[i-1][j],mem[i][j-1]),mem[i-1][j-1])+1;
            }
        }
        return mem[l1][l2];
    }

    public static void main(String[] args) {
        NO72_EditDistance editDistance = new NO72_EditDistance();
        editDistance.minDistance("a","b");
    }

}
