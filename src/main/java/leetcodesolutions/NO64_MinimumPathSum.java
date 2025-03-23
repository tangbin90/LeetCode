package leetcodesolutions;

/**
 * @author TangBin
 * @version V1.0
 * @date 04/12/2017 10:24 PM
 */
public class NO64_MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if(grid==null)
            return 0;
        int rowNum = grid.length;
        int colNum = grid[0].length;

        int[][] result = new int[rowNum][colNum];
        result[rowNum-1][colNum-1]=grid[rowNum-1][colNum-1];
        for(int i=rowNum-2;i>=0;i--){
            result[i][colNum-1]=grid[i][colNum-1]+result[i+1][colNum-1];
        }
        for(int i=colNum-2;i>=0;i--){
            result[rowNum-1][i]=grid[rowNum-1][i]+result[rowNum-1][i+1];
        }

        for(int i=rowNum-2;i>=0;i--){
            for(int j=colNum-2;j>=0;j--){
                result[i][j] = Math.min(result[i+1][j],result[i][j+1])+grid[i][j];
            }
        }
        return result[0][0];

    }



    public static void main(String[] args) {
        int[][] input = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(new NO64_MinimumPathSum().minPathSum(input));
    }
}
