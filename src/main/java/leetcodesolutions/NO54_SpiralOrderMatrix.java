package leetcodesolutions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 17082720 tangbin
 * @create: 2017/12/1 14:16
 * @description:
 */
public class NO54_SpiralOrderMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if(matrix.length==0)
            return ans;
        int colBegin=0;
        int rowBegin=0;
        int colEnd=matrix[0].length-1;
        int rowEnd=matrix.length-1;
        while(colBegin<=colEnd||rowBegin<=rowEnd){

            for(int i=colBegin;i<=colEnd&&rowBegin<=rowEnd;i++){
                ans.add(matrix[rowBegin][i]);
            }
            for(int i=rowBegin+1;i<=rowEnd&&colBegin<=colEnd;i++){
                ans.add(matrix[i][colEnd]);
            }

            for(int i=colEnd-1;i>=colBegin&&rowEnd>rowBegin;i--){
                ans.add(matrix[rowEnd][i]);
            }

            for(int i=rowEnd-1;i>rowBegin&&colBegin<colEnd;i--){
                ans.add(matrix[i][colBegin]);
            }
            colBegin+=1;
            rowBegin+=1;
            colEnd-=1;
            rowEnd-=1;
        }
        return ans;
    }

    public static void main(String[] args){
        int[][] matrix = new int[3][3];
        int[] row1 = new int[]{1,2,3};
        int[] row2 = new int[]{4,5,6};
        int[] row3 = new int[]{7,8,9};
        matrix[0]=row1;
        matrix[1]=row2;
        matrix[2]=row3;
        List<Integer> ans = new NO54_SpiralOrderMatrix().spiralOrder(matrix);
        System.out.println(ans);

    }
}
