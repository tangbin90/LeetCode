package leetcodesolutions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 17082720 tangbin
 * @create: 2017/12/5 9:02
 * @description: Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 * Follow up:
Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
 */
public class NO73_SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        List<Integer> colNums = new ArrayList<Integer>();
        List<Integer> rowNums = new ArrayList<Integer>();

        for(int i=0;i<rowNum;i++){
            for(int j=0;j<colNum;j++){
                if(matrix[i][j]==0) {
                    colNums.add(j);
                    rowNums.add(i);
                }
            }
        }

        for(int i:colNums){
            for(int j=0;j<rowNum;j++){
                matrix[j][i]=0;
            }
        }
        for(int i:rowNums){
            for(int j=0;j<colNum;j++){
                matrix[i][j]=0;
            }
        }
    }
    public static void main(String[] args){
        NO73_SetMatrixZeroes setMatrixZeroes = new NO73_SetMatrixZeroes();
        int[][] input = {{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}};
        setMatrixZeroes.setZeroes(input);
    }

}
