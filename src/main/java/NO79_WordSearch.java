/**
 * @author TangBin
 * @version V1.0
 * @date 06/12/2017 11:01 PM
 */
public class NO79_WordSearch {
    public boolean exist(char[][] board, String word) {
        int rowNum = board.length;
        int colNum = board[0].length;
        boolean[][] searchedPoint = new boolean[rowNum][colNum];
        for(int i=0;i<rowNum;i++){
            for(int j=0;j<colNum;j++){
                if(dpExist(board,searchedPoint,i, j, word,0))
                    return true;
            }
        }
        return false;
    }

    public boolean dpExist(char[][]board,boolean[][] searchedPoint,int row, int col,String word,int wordStart){
        if(wordStart==word.length())
            return true;
        int rowNum = board.length;
        int colNum = board[0].length;
        if(row<0||col<0||row>=rowNum||col>=colNum||searchedPoint[row][col])
            return false;
        if(board[row][col]==word.charAt(wordStart)) {
            boolean right = false;
            boolean up = false;
            boolean left = false;
            boolean down = false;
            searchedPoint[row][col] = true;
            right = dpExist(board, searchedPoint, row, col + 1, word, wordStart + 1);
            left = dpExist(board, searchedPoint, row, col - 1, word, wordStart + 1);
            up = dpExist(board, searchedPoint, row - 1, col, word, wordStart + 1);
            down = dpExist(board, searchedPoint, row + 1, col, word, wordStart + 1);
            if(right||left||up||down)
                return true;
            searchedPoint[row][col]=false;
        }
        return false;

    }
}
