package labula;

/**
 * @author TangBin
 * @version V1.0
 * @date 31/03/2017 10:13 PM
 */
public class PickCoins {
    private final int[] coins={1,2,3,4,5,6,7,8,9};
    public int pickCoins(int sum){
        int[] dnum=new int[sum+1];

        for(int i=0;i<sum+1;i++){
            dnum[i]=Integer.MAX_VALUE;
        }
        dnum[0]=0;
        for (int i=1;i<=sum;i++){
            for(int j=0;j<coins.length;j++){
                if(coins[j]<=i&&dnum[i-coins[j]]+1<dnum[i])
                    dnum[i]=dnum[i-coins[j]]+1;
            }
        }
        return dnum[sum];
    }

    public static void main(String[] args){
        PickCoins pc = new PickCoins();
        System.out.println(pc.pickCoins(11));

    }
}
