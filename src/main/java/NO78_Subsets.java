import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author TangBin
 * @version V1.0
 * @date 05/12/2017 11:52 PM
 */
public class NO78_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans= new LinkedList<>();
        for(int i=0;i<nums.length;i++){
            List<List<Integer>> temp = new LinkedList<>();
            for(List<Integer> li :ans){
                List<Integer>  liCopy= new ArrayList<>(li);
                liCopy.add(nums[i]);
                temp.add(liCopy);
            }
            ans.addAll(temp);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3};
        List<List<Integer>> ls = new NO78_Subsets().subsets(nums);
        System.out.println(ls);
    }

}
