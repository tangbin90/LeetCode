import java.util.Map;

/**
 * @author: 17082720 tangbin
 * @create: 2017/12/1 10:16
 * @description:
 */
public class NO48_RotateImage {
    public void rotate(int[][] matrix){
        for(int i=0;i<matrix.length/2;i++){
            int[] temp =  matrix[i];
            matrix[i]=matrix[matrix.length-i-1];
            matrix[matrix.length-i-1]=temp;
        }

        for(int i=0;i<matrix.length;i++) {
            for (int j = 0; j < i; j++) {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
    }




}
