/**
 * Created by tangbin1 on 2017/7/10.
 */
public class NO62_UniquePaths {
    public int uniquePaths(int m, int n){
        return uniquePaths(m, n, 1,1);
    }

    public int uniquePaths(int m, int n, int positionx, int positiony){

        if(positionx<m&&positiony<n) {
            int leftcount = uniquePaths(m, n, positionx + 1, positiony);
            int downcount = uniquePaths(m, n, positionx, positiony + 1);
            return leftcount+downcount;
        }
        return 1;
    }

    public int dpSolution(int m, int n){
        Integer[][] map = new Integer[m][n];
        for(int i=0;i<m;i++)
            map[i][0] = 1;

        for(int j=0;j<n;j++)
            map[0][j] = 1;

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++)
                map[i][j] = map[i-1][j]+map[i][j-1];
        }
        return map[m-1][n-1];
    }
    public static void main(String... args) {
        System.out.println(new NO62_UniquePaths().uniquePaths(23,12));
    }
}
