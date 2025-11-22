package leetcodesolutions;

public class NO308 {
    private int[][] bits;
    private int rowl;
    private int coll;
    private int[][] mm;

    public NO308(int[][] matrix) {
        rowl = matrix.length;
        coll = matrix[0].length;
        bits = new int[rowl + 1][coll + 1];
        mm = new int[rowl][coll];
        for(int i=0; i<rowl; i++){
            for(int j=0; j<coll; j++){
                mm[i][j] = matrix[i][j];
                int delta = mm[i][j];
                updateHelp(delta,i+1, j+1);
            }
        }

    }

    private void updateHelp(int delta, int i, int j){
        for(int m = i; m < rowl+1; m += m & (-m)){
            for(int n = j; n < coll+1; n += n & (-n)){
                bits[m][n] += delta;
            }
        }
    }

    public void update(int row, int col, int val) {
        int delta = val - mm[row][col];
        updateHelp(delta, row+1, col+1);
        mm[row][col] = val;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum(row2, col2) - sum(row2, col1 -1) - sum(row1 - 1, col2) + sum(row1-1, col1-1);
    }

    public int sum(int row, int col){
        int row1 = row + 1;
        int col1 = col + 1;

        int rslt = 0;

        for(int i = row1; i > 0; i-= i&(-i)){
            for(int j = col1; j > 0; j -= j&(-j)){
                rslt += bits[i][j];
            }
        }
        return rslt;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        NO308 numMatrix = new NO308(matrix);
        System.out.println(numMatrix.sumRegion(2,1,4,3)); //8
        numMatrix.update(3,2,2);
        System.out.println(numMatrix.sumRegion(2,1,4,3)); //10
    }
/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */
}
