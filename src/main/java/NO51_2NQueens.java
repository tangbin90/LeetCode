import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NO51_2NQueens {


    public List<Character[][]> solveNQueens(int n) {
        //Initialize the board
        List<Character[][]> res = new LinkedList<>();

        Character[][] board = new Character[n][n];
        for(int i = 0; i< n; i++){
            Arrays.fill(board[i], '.');
        }

        //DFS
        dfs(board, 0, n, res);
        return res;
    }

    void dfs(Character[][] board, int row, int n, List<Character[][]> res){
        if(row == n){
            Character[][] copy = new Character[n][n];
            for(int i = 0; i<n; i++){
                copy[i] = board[i].clone();
            }
            res.add(copy);
            return;
        }

        for(int i = 0; i<n; i++){
            if(isValid(board, row, i)){
                board[row][i] = 'Q';
                dfs(board, row+1, n, res);
                board[row][i] = '.';
            }
        }
    }
    public boolean isValid(Character[][] board, int row, int col){
        int n = board.length;
        for(int i = 0; i<row; i++){
            if(board[i][col] == 'Q')
                return false;
        }

        for(int i = row-1, j = col-1; i>=0&&j>=0; i--, j--){
            if(board[i][j] == 'Q')
                return false;
        }

        for(int i = row-1, j = col+1; i>=0&&j<n; i--, j++){
            if(board[i][j] == 'Q')
                return false;
        }
        return true;

    }

    public static void main(String[] args) {
        NO51_2NQueens solution = new NO51_2NQueens();
        List<Character[][]> res = solution.solveNQueens(4);
        for(Character[][] board : res){
            for(Character[] row : board){
                for(Character c : row) {
                    System.out.print(c);
                }
                System.out.println();       
            }
            System.out.println();
        }
    }   
}
