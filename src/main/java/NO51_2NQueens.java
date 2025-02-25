import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NO51_2NQueens {

    public List<char[][]> solveNQueens(int n) {
        // Initialize the board
        List<char[][]> res = new ArrayList<>();

        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        // DFS
        dfs(board, 0, n, res);
        return res;
    }

    void dfs(char[][] board, int row, int n, List<char[][]> res) {
        if(row == n) {
            char[][] copy = new char[n][n];
            for(int i = 0; i < n; i++) {
                copy[i] = board[i].clone();
            }
            res.add(copy);
            return;
        }

        for(int i = 0; i < n; i++) {
            if(isValid(board, row, i)) {
                board[row][i] = 'Q';
                dfs(board, row + 1, n, res);
                board[row][i] = '.';
            }
        }
    }

    public boolean isValid(char[][] board, int row, int col) {
        // Check column
        for(int i = 0; i < row; i++) {
            if(board[i][col] == 'Q')
                return false;
        }

        // Check diagonal \
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if(board[i][j] == 'Q')
                return false;
        }

        // Check diagonal /
        for(int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if(board[i][j] == 'Q')
                return false;
        }
        
        return true;
    }

    public static void main(String[] args) {
        NO51_2NQueens solution = new NO51_2NQueens();
        List<char[][]> res = solution.solveNQueens(4);
        for(char[][] board : res) {
            for(char[] row : board) {
                System.out.println(new String(row));
            }
            System.out.println();
        }
    }   
}
