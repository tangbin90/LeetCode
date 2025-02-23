

/**
 * @author TangBin
 * @version V1.0
 * @date 01/04/2017 9:26 AM
 */
public class NO300_LongestIncreasingSubsequence {
    public int LIS(int[] nums){
        int arrayLength = nums.length;
        int[] dint=new int[arrayLength];
        int len=0;
        for(int i=0;i<arrayLength;i++){
            dint[i]=1;
            for(int j=0;j<i;j++){
                if(nums[i]>=nums[j]&&dint[j]+1>dint[i])
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
        int[] array = new int[]{1,2,3,2,1,2,3,4,5,6,7};
        NO300_LongestIncreasingSubsequence longIS = new NO300_LongestIncreasingSubsequence();
        System.out.println(longIS.LIS(array));
    }
}
