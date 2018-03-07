import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author TangBin
 * @version V1.0
 * @date 11/04/2017 9:47 AM
 */

public class NO15_ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i=0;i+2<nums.length;i++){
            int target=-nums[i];
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int j = i + 1;
                int tail = nums.length - 1;
                while (j < tail) {
                    if (nums[j] + nums[tail] == target) {
                        List<Integer> tempList = new ArrayList<>();
                        tempList.addAll(Arrays.asList(nums[i], nums[j], nums[tail]));
                        res.add(tempList);
                        while (j < tail && nums[j] == nums[j + 1]) j++;
                        while (j < tail && nums[tail] == nums[tail - 1]) tail--;
                        j++;
                        tail--;

                    } else if (nums[j] + nums[tail] < target) {
                        j++;
                    } else
                        tail--;

                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        int[] nums = new int[]{1,2,3,-1,-1,-2,-3,0,1};
        List<List<Integer>> lli = threeSum(nums);
        for(List<Integer> li : lli){
            for(Integer i : li){
                System.out.printf(i+" ");
            }
            System.out.println();
        }
    }
}
