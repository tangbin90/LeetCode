package leetcodesolutions;

public class NO304 {
    private int[][] sum;
    public NO304(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        sum = new int[m][n+1];
        for(int i=0; i<m;i++){
            for(int j=1; j<=n; j++){
                sum[i][j] = sum[i][j-1] + matrix[i][j-1];
            }
        }


    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int rslt = 0;
        for(int i=row1; i<=row2; i++){
            rslt += sum[i][col2+1] - sum[i][col1];
        }

        return rslt;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {3,0,1,4,2},
                {5,6,3,2,1},
                {1,2,0,1,5},
                {4,1,0,1,7},
                {1,0,3,0,5}
        };
        NO304 no304 = new NO304(matrix);
        System.out.println(no304.sumRegion(2, 1, 4, 3)); // 8
        System.out.println(no304.sumRegion(1, 1, 2, 2)); // 11
        System.out.println(no304.sumRegion(1, 2, 2, 4)); // 12
    }
}
