import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * @author: 17082720 tangbin
 * @create: 2017/12/8 9:18
 * @description:
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 6.
 */
public class NO85_MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0||matrix[0].length==0)
            return 0;
        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        int[] leftWidth = new int[colNum];
        int[] rightWidth = new int[colNum];
        int[] height = new int[colNum];
        int maxA = 0;
        for(int i=0;i<colNum;i++){
            leftWidth[i]=0;
            rightWidth[i]=colNum;
            height[i]=0;
        }
        for(int i=0;i<rowNum;i++){
            for(int j=0;j<colNum;j++){
                if(matrix[i][j]=='1') height[j]=height[j]+1;
                else {
                    height[j]=0;
                }
            }
            int currLeft=0;
            int currRight = colNum;
            for(int j=0;j<colNum;j++){
                if(matrix[i][j]=='1') leftWidth[j]=max(leftWidth[j],currLeft);
                else {
                    leftWidth[j]=0;
                    currLeft=j+1;
                }
            }
            for(int j=colNum-1;j>=0;j--){
                if(matrix[i][j]=='1') rightWidth[j]=min(rightWidth[j],currRight);
                else {
                    rightWidth[j]=colNum;
                    currRight=j;
                }
            }

            for(int j=0; j<colNum; j++)
                maxA = max(maxA,(rightWidth[j]-leftWidth[j])*height[j]);

        }

        return maxA;
    }

    public static void main(String[] args){
        char[][] matrix = new char[][]{{'0','0'},{'1','1'},{'1','1'},{'1','0'}};
        NO85_MaximalRectangle  maximalRectangle = new NO85_MaximalRectangle();
        System.out.println( maximalRectangle.maximalRectangle(matrix));
    }
}
