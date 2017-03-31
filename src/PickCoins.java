import java.util.ArrayList;
import java.util.List;

/**
 * @author TangBin
 * @version V1.0
 * @date 31/03/2017 10:13 PM
 */
public class PickCoins {
    private final int[] coins={1,3,5};
    public int pickCoins(int sum){
        List<Integer> dnum=new ArrayList<Integer>();

        for(int i=0;i<sum;i++){
            dnum.add(1);
        }
        System.out.println(dnum.toString());
        return 0;
    }

    public static void main(String[] args){
        PickCoins pc = new PickCoins();
        pc.pickCoins(10);
    }
}
