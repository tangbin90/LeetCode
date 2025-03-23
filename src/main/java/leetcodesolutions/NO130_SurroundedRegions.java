package leetcodesolutions;

/**
 * @author TangBin
 * @version V1.0
 * @date 29/03/2018 9:14 PM
 */
public class NO130_SurroundedRegions {
    public void solve(char[][] board) {
        if(board==null||board.length==0||board[0].length==0)
            return;
        boolean[][] mem = new boolean[board.length][board[0].length];
        int rowNum = board.length;
        int colNum = board[0].length;
        for(int i=0;i<rowNum;i++) {
            for (int j = 0; j < colNum; j++) {
                if (isSideElement(i, j, rowNum, colNum) && !mem[i][j])
                    solve(board, mem, i, j);
            }
        }

        for(int i=0;i<rowNum;i++) {
            for (int j = 0; j < colNum; j++) {
                if(board[i][j]=='O')
                    board[i][j]='X';
                if(board[i][j]=='*')
                    board[i][j]='O';
            }
        }
    }

    private void solve(char[][] board, boolean[][] mem, int i, int j){
        if(i>=board.length||j>=board[0].length||i<0||j<0)
            return;
        if(mem[i][j])
            return;
        mem[i][j]=true;
        if(board[i][j]=='O') {
            board[i][j] = '*';
            solve(board,mem,i+1,j);
            solve(board,mem,i,j+1);
            solve(board,mem,i-1, j);
            solve(board, mem, i,j-1);
        }
    }
    private boolean isSideElement(int i, int j, int rowNum, int colNum){
        if(i==0||i==rowNum-1||j==0||j==colNum-1)
            return true;
        return false;
    }
}
