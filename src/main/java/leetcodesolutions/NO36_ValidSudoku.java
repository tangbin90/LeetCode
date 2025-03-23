package leetcodesolutions; /**
 * Copyright (C), 2015-2018, 苏宁金融集团
 * Author: TangBin 17082720
 * FileName: NO206_ValidSudoku
 * Date: 2018/3/2 17:08
 * Description: 数独验证
 */

/**
 * @author: TangBin 17082720 
 * @Email: 17082720@cnsuning.com
 * @create: 2018/3/2 17:08
 * @since 1.0.0
 * @description: 〈数独验证〉
 */
public class NO36_ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int rowNum = board.length;
        int colNum = board[0].length;
        if(rowNum!=9||colNum!=9)
            return false;

        int[][] rowMatrix = new int[rowNum][colNum];
        int[][] colMatrix = new int[rowNum][colNum];
        int[][] subMatrix = new int[rowNum][colNum];
        for(int i=0;i<rowNum;i++){
            for(int j=0;j<colNum;j++){
                if(board[i][j]=='.')
                    continue;
                if(board[i][j]>'9'||board[i][j]<'1')
                  return false;
                if(rowMatrix[i][board[i][j]-'1']==1||colMatrix[j][board[i][j]-'1']==1||
                        subMatrix[i/3*3+j/3][board[i][j]-'1']==1)
                    return false;
                rowMatrix[i][board[i][j]-'1']=1;
                colMatrix[j][board[i][j]-'1']=1;
                subMatrix[i/3*3+j/3][board[i][j]-'1']=1;
            }
        }
        return true;
    }
}
