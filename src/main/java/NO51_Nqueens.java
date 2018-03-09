/**
 * Copyright (C), 2015-2018, 苏宁金融集团
 * Author: TangBin 17082720
 * FileName: Nqueens
 * Date: 2018/3/9 15:54
 * Description:
 */

import java.util.LinkedList;
import java.util.List;

/**
 * @author: TangBin 17082720 
 * @Email: 17082720@cnsuning.com
 * @create: 2018/3/9 15:54
 * @since 1.0.0
 * @description: 〈The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
[".Q..",  // Solution 1
"...Q",
"Q...",
"..Q."],

["..Q.",  // Solution 2
"Q...",
"...Q",
".Q.."]
]〉
 */
public class NO51_Nqueens {
    public List<List<String>> solveNQueens(int n) {
        int[] mem  = new int[n];
        List<List<String>> res = new LinkedList<>();
        solveNqueue(n,mem,0,res);
        return res;
    }

    private void solveNqueue(int n,int[] mem,int row,List<List<String>> res){
        if(row==n){
            res.add(memToStringList(mem));
        }else{
            for(int i=0;i<n;i++){
                mem[row]=i;
                if(isIllegal(mem,row))
                    solveNqueue(n,mem,row+1,res);
            }
        }

    }

    private List<String> memToStringList(int[] mem){
        char[] chars = new char[mem.length];
        List<String> res = new LinkedList<>();
        for(int i=0;i<mem.length;i++){
            chars[i]='.';
        }
        for(int i=0;i<mem.length;i++){
            chars[mem[i]]='Q';
            res.add(String.valueOf(chars));
            chars[mem[i]]='.';
        }
        return res;
    }

    private boolean isIllegal(int[] mem, int row){
        for(int i=0;i<row;i++){
            if(mem[i]==mem[row]||mem[i]+i==mem[row]+row||mem[i]-i==mem[row]-row)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        NO51_Nqueens nqueens = new NO51_Nqueens();
        List<List<String>> lls = nqueens.solveNQueens(8);
        System.out.println(lls);
    }

}
