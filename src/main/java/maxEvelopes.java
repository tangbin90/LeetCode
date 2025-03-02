import java.util.Arrays;
import java.util.Comparator;

public class maxEvelopes {
    public static int maxEnvelopes(int[][] envelopes){
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]==o1[1]? o2[1] - o1[1] : o1[0] -o2[0];
            }
        });

        int[] height = new int[envelopes.length];
        for(int i=0; i< envelopes.length; i++)
            height[i] = envelopes[i][1];

        return LIS.lts(height);

    }
}
