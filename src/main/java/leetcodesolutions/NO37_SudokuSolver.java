package leetcodesolutions; /**
 * Copyright (C), 2015-2018, 苏宁金融集团
 * Author: TangBin 17082720
 * FileName: NO37_SudokuSolver
 * Date: 2018/3/6 15:16
 * Description: 数据解决方法
 */

/**
 * @author: TangBin 17082720 
 * @Email: 17082720@cnsuning.com
 * @create: 2018/3/6 15:16
 * @since 1.0.0
 * @description: 〈数据解决方法〉
 */
public class NO37_SudokuSolver {
    public void solveSudoku(char[][] board){
        if(board == null || board.length == 0)
            return;
        solve(board);
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
    public boolean solve(char[][] board) {
        int rowNum = board.length;
        int colNum = board[0].length;

        for(int i=0;i<rowNum;i++){
            for(int j=0;j<colNum;j++){
                if(board[i][j]=='.'){
                    for(char m ='1';m<='9';m++){
                        if(isValid(board,i,j,m)) {
                            board[i][j] = m;
                            if(solve(board))
                                return true;
                            else
                                board[i][j]='.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValid(char[][] board, int i, int j, char m){
        for(int k=0;k<9;k++){
            if(board[i][k]==m) return false;
            if(board[k][j]==m) return false;
            if(board[i/3*3+k/3][j/3*3+k%3]==m) return false;
        }
        return true;
    }

    public static void main(String[] args){
        // NO37_SudokuSolver sudokuSolver = new NO37_SudokuSolver();
    }
}
