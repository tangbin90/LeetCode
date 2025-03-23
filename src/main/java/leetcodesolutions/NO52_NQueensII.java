package leetcodesolutions; /**
 * Copyright (C), 2015-2018, 苏宁金融集团
 * Author: TangBin 17082720
 * FileName: NO53_NQueensII
 * Date: 2018/3/9 17:37
 * Description:
 */

/**
 * @author: TangBin 17082720 
 * @Email: 17082720@cnsuning.com
 * @create: 2018/3/9 17:37
 * @since 1.0.0
 * @description: 〈〉
 */
public class NO52_NQueensII {
    private int count = 0;
    public int totalNQueens(int n) {
        int[] mem  = new int[n];
        solveNqueue(n,mem,0);
        return count;
    }

    private void solveNqueue(int n,int[] mem,int row){
        if(row==n){
            count++;
        }else{
            for(int i=0;i<n;i++){
                mem[row]=i;
                if(isIllegal(mem,row))
                    solveNqueue(n,mem,row+1);
            }
        }

    }

    private boolean isIllegal(int[] mem, int row){
        for(int i=0;i<row;i++){
            if(mem[i]==mem[row]||mem[i]+i==mem[row]+row||mem[i]-i==mem[row]-row)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        NO52_NQueensII nqueens = new NO52_NQueensII();
        int lls = nqueens.totalNQueens(8);
        System.out.println(lls);
    }
}
