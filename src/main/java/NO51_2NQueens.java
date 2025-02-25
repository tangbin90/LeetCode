import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NO51_2NQueens {

    List<List<char[]>> res = new LinkedList<>();

    public List<List<String>> solveNQueens(int n) {
        //Initialize the board

        List<char[]> board = new LinkedList<>();
        for(int i = 0; i< n; i++){
            char[] row = new char[n];
            Arrays.fill(row, '.');
            board.add(row);
        }

        //DFS
        dfs(board, 0, n);
        return res;
    }

    void dfs(List<char[]> board, int row, int n){
        if(row == n){
            res.add(board);
            return;
        }

        for(int i = 0; i<n; i++){
            if(isValid(board, row, i)){
                board.get(row).re;
                dfs(board, row+1, n);
                board.get(row).set(i, ".");
            }
        }
    }
    public boolean isValid(List<char[]> board, int row, int col){
        int n = board.size();
        for(int i = 0; i<row; i++){
            if(board.get(i)[col] == 'Q')
                return false;
        }

        for(int i = row-1, j = col-1; i>=0&&j>=0; i--, j--){
            if(board.get(i)[j] == 'Q')
                return false;
        }

        for(int i = row-1, j = col+1; i>=0&&j<n; i--, j++){
            if(board.get(i)[j] == 'Q')
                return false;
        }
        return true;

    }
}
