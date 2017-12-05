/**
 * @author: 17082720 tangbin
 * @create: 2017/12/5 10:12
 * @description:Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
[1,   3,  5,  7],
[10, 11, 16, 20],
[23, 30, 34, 50]
]
Given target = 3, return true.
 */
public class NO74_SearchInMatrix {
    public boolean searchMatrix(int[][] matrix,int target){
        if(matrix.length==0||matrix[0].length==0)
            return false;
        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        int rowNumTemp=0;
        for(int i=0;i<=rowNum-1;i++){
            if(target<matrix[i][colNum-1]) {
                rowNumTemp=i;
                break;
            }
            else if(target==matrix[i][colNum-1])
                return true;
        }
        for(int i=0;i<colNum-1;i++){
            if(target==matrix[rowNumTemp][i])
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1}};
        NO74_SearchInMatrix searchInMatrix = new NO74_SearchInMatrix();
        searchInMatrix.searchMatrix(matrix,2);
    }
}
