package leetcodesolutions;

/**
 * @author: 17082720 tangbin
 * @create: 2017/12/4 10:11
 * @description:Follow
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?
 * up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
[0,0,0],
[0,1,0],
[0,0,0]
]
The total number of unique paths is 2.
 */
public class NO63_UniquePath {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int result = 0;
        int[][] pathLength = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i=0;i<obstacleGrid.length;i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                pathLength[i][j]=-1;
            }
        }
        pathLength[pathLength.length-1][pathLength[0].length-1]=
                obstacleGrid[pathLength.length-1][pathLength[0].length-1]==1?0:1;
        result = uniquePathsWithObstacles(obstacleGrid,0,0,pathLength);
        return result;
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid, int row, int col, int[][] pathLength){
        if(pathLength[row][col]!=-1)
            return pathLength[row][col];
        if(obstacleGrid[row][col]==1) {
            pathLength[row][col]=0;
            return 0;
        }
        int right=0;
        int left=0;
        if(row<obstacleGrid.length-1)
            left = uniquePathsWithObstacles(obstacleGrid,row+1,col,pathLength);

        if(col<obstacleGrid[0].length-1)
            right = uniquePathsWithObstacles(obstacleGrid,row,col+1,pathLength);
        pathLength[row][col]=left+right;
        return right+left;
    }
    public int uniquePathsWithObstaclesII(int[][] obstacleGrid) {
        int result;
        int[][] pathLength = new int[obstacleGrid.length][obstacleGrid[0].length];
        result = dpSolution(obstacleGrid,pathLength);
        return result;
    }
    public int dpSolution(int[][] obstacleGrid, int[][] pathLength){
        int row = obstacleGrid.length-1;
        int col = obstacleGrid[0].length-1;
        pathLength[row][col]=obstacleGrid[row][col]==1?0:1;
        int blockPos=-1;
        for(int i=row;i>=0;i--){
            if(obstacleGrid[i][col]==1) {
                blockPos=i;
                break;
            }
            pathLength[i][col]=1;
        }
        if(blockPos!=-1){
            for(int i=0;i<=blockPos;i++){
                pathLength[i][col]=0;
            }
        }
        blockPos=-1;
        for(int i=col;i>=0;i--){
            if(obstacleGrid[row][i]==1) {
                blockPos=i;
                break;
            }
            pathLength[row][i]=1;
        }
        if(blockPos!=-1){
            for(int i=0;i<=blockPos;i++){
                pathLength[row][i]=0;
            }
        }

        for(int i=row-1;i>=0;i--){
            for(int j=col-1;j>=0;j--){
                if(obstacleGrid[i][j]==1)
                    pathLength[i][j]=0;
                else
                    pathLength[i][j]=pathLength[i+1][j]+pathLength[i][j+1];
            }
        }
        return pathLength[0][0];
    }

    public static void main(String[] args) {
        NO63_UniquePath uniquePath = new NO63_UniquePath();
        int[][] data = {{0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},{0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0},{1,1,1,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,1,0,0,0,0,0,0,0,0,1,0,0,1},{0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0},{0,0,0,1,0,1,0,0,0,0,1,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,1,0},{1,0,1,1,1,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0},{0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,1,0,0,0,1,0,1,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,1,0},{0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,1,0,0,0,0,0},{0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},{1,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0,1,0,0,0,1,0,1,0,0,0,0,1},{0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,1,0,0,0,0,0,0,1,1,0,0,0,0,0},{0,1,0,1,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,0,0,0,0,0},{0,1,0,0,0,0,0,0,1,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,1,0,1},{1,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,1,0,0,1,0,0,0,0,0,0},{0,0,1,0,0,0,0,0,0,0,1,0,0,1,0,0,1,0,0,0,0,0,0,1,1,0,1,0,0,0,0,1,1},{0,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,1,1,0,1,0,1},{1,1,1,0,1,0,0,0,0,1,0,0,0,0,0,0,1,0,1,0,1,1,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,1,1},{0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,1,0,0,0,1,0,0,0}};
        int result = uniquePath.uniquePathsWithObstaclesII(data);
        System.out.println(result);
    }


}
