import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author TangBin
 * @version V1.0
 * @date 01/04/2017 9:26 AM
 */
public class LongestIncreasingSubsequence {
    public int LIS(ArrayList<Integer> list){
        int arrayLength = list.size();
        int[] dint=new int[arrayLength];
        int len=0;
        for(int i=0;i<arrayLength;i++){
            dint[i]=1;
            for(int j=0;j<i;j++){
                if(list.get(i)>=list.get(j)&&dint[j]+1>dint[i])
                    dint[i]=dint[j]+1;
            }
            if(dint[i]>len)
                len=dint[i];
        }

        for(int i=0;i<dint.length;i++)
            System.out.print(dint[i]);
        return len;
    }

    public static void main(String[] args){
        ArrayList<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(1,2,3,2,1,2,3,4,5,6,7));
        LongestIncreasingSubsequence longIS = new LongestIncreasingSubsequence();
        System.out.println(longIS.LIS(arrayList));
    }
}
