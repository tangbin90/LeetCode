/**
 * @author: 17082720 tangbin
 * @create: 2017/12/4 9:50
 * @description:
 * given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
[ 1, 2, 3 ],
[ 8, 9, 4 ],
[ 7, 6, 5 ]
]

 */
public class NO59_SpiralMatrix {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        for(int i=0;i<n;i++){
            result[i] = new int[n];
        }
        int rowStart = 0;
        int rowEnd = n-1;
        int colStart = 0;
        int colEnd = n-1;
        int num=1;
        while(rowStart<=rowEnd&&colStart<=colEnd){
            for(int i=colStart;i<=colEnd;i++){
                result[rowStart][i] = num++;
            }
            for(int i=rowStart+1;i<=rowEnd;i++){
                result[i][colEnd] = num++;
            }
            for(int i=colEnd-1;i>=colStart&&rowStart<rowEnd;i--){
                result[rowEnd][i] = num++;
            }
            for(int i=rowEnd-1;i>rowStart&&colStart<colEnd;i--){
                result[i][colStart] = num++;
            }

            colStart++;
            colEnd--;
            rowStart++;
            rowEnd--;
        }

        return result;
    }
}
