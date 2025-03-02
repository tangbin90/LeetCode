import java.util.Arrays;

import static java.lang.Math.max;

public class LIS {
    //int[] array = {1,234,5,664,,74, 84}
    //dp[i] in position i, what is the LTS number
    public static int lts(int[] array){
        int[] dp = new int[array.length];
        Arrays.fill(dp, 1);

        for(int i=0; i < array.length; i++){
            for(int j=0; j < i; j++){
                if(array[i] > array[j]){
                    dp[i] = max(dp[j]+1, dp[i]);
                }
            }
        }

        int result = 1;
        for(int i=0; i < dp.length; i++){
            result = max(result, dp[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {1,234,5,664,74};
        System.out.println(lts(array));
    }

}
