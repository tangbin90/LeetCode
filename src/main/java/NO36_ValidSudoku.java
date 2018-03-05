/**
 * @author TangBin
 * @version V1.0
 * @date 05/03/2018 8:51 PM
 */
public class NO36_ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int rowNum = board.length;
        int colNum = board[0].length;

        if(rowNum!=9||colNum!=9)
            return false;

        for(int i=0;i<rowNum;i++){
            int[] rowArray = new int[rowNum+1];
            for(int j=0;j<colNum;j++){
                if(board[i][j]=='.')
                    continue;
                if(board[i][j]>='1'&& board[i][j]<='9') {
                    if (rowArray[board[i][j]-'0'] == 1)
                        return false;
                    else
                        rowArray[board[i][j]-'0']++;
                }else
                    return false;
            }
        }
        for(int i=0;i<colNum;i++) {
            int[] colArray = new int[colNum+1];
            for (int j = 0; j < rowNum ; j++) {
                if (board[j][i] == '.')
                    continue;
                if (board[j][i] >= '1' && board[j][i] <= '9') {
                    if (colArray[board[j][i] - '0'] >= 1)
                        return false;
                    else colArray[board[j][i] - '0']++;
                } else
                    return false;
            }
        }

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                int[] array = new int[10];
                for(int k=i*3;k<i*3+3;k++){
                    for(int m=j*3;m<j*3+3;m++){
                        if(board[k][m]=='.')
                            continue;
                        if(board[k][m]>='1'&& board[k][m]<='9') {
                            if (array[board[k][m]-'0'] == 1)
                                return false;
                            else
                                array[board[k][m]-'0']++;
                        }else
                            return false;
                    }
                }
            }
        }
        return true;
    }
    public static void main(String[] args){
        char[][] aa = {{'.','.','4','.','.','.','6','3','.'},{'.','.','.','.','.','.','.','.','.'},{'5','.','.','.','.','.','.','9','.'},{'.','.','.','5','6','.','.','.','.'},{'4','.','3','.','.','.','.','.','1'},{'.','.','.','7','.','.','.','.','.'},{'.','.','.','5','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'}};
        System.out.println( new NO36_ValidSudoku().isValidSudoku(aa));
    }

}
