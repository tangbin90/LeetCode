package leetcodesolutions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author TangBin
 * @version V1.0
 * @date 11/03/2018 8:41 PM
 * "123"
"132"
"213"
"231"
"312"
"321"
 */
public class NO60_PermutationSequence {
    public String getPermutation(int n, int k) {
        int[] nums= new int[n+1];
        int temp = 1;
        StringBuilder sb = new StringBuilder();
        List<Integer> numbers = new ArrayList<>();
        nums[0]=1;
        for(int i=1;i<=n;i++){
            temp = temp*i;
            nums[i]=temp;
        }

        for(int i=1; i<=n; i++){
            numbers.add(i);
        }
        k--;
        for(int i=1;i<=n;i++){
            int integer = k/nums[n-i];
            if(integer>=numbers.size())
                return "";
            sb.append(String.valueOf(numbers.get(integer)));
            numbers.remove(integer);
            k-=integer*nums[n-i];
        }
        return sb.toString();
    }

    public static void main(String[] args){
        System.out.println(new NO60_PermutationSequence().getPermutation(9,54));
    }
}
