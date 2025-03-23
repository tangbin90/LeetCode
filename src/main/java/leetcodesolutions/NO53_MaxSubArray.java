package leetcodesolutions;

/**
 * @author: 17082720 tangbin
 * @create: 2017/12/1 11:01
 * @description:
 */
public class NO53_MaxSubArray {
    public int maxSubArray(int[] nums){
        if(nums.length==0)
            return 0;
        int ans=nums[0];
        int tempAns=nums[0];
        for(int i=1;i<nums.length;i++){
            if(tempAns<0) {
                if(nums[i]>ans)
                    ans=nums[i];
                tempAns=nums[i];
            }else{
                tempAns+=nums[i];
                if(ans<tempAns)
                    ans=tempAns;
            }
        }
        return ans;
    }

    public static void main(String... args){
        NO53_MaxSubArray maxSubArray = new NO53_MaxSubArray();
        System.out.println(maxSubArray.maxSubArray(new int[]{8,-19,5,-4,20}));
    }
}
