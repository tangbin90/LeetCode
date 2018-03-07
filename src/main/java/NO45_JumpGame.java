/**
 * @author: 17082720 tangbin
 * @create: 2017/12/1 14:57
 * @description:
 */
public class NO45_JumpGame {
    public boolean canJump(int[] nums) {
        int maxPath=nums[0];
        int iter=0;
        while(iter<=maxPath&&iter<nums.length){
            maxPath=Math.max(nums[iter]+iter,maxPath);
            iter++;
        }
        return maxPath>=nums.length-1;
    }

    public static void main(String[] args){
        NO45_JumpGame jumpGame = new NO45_JumpGame();
        //int[] nums = new int[]{2,3,1,1,4};
        int[] nums= new int[]{0};
        System.out.println(jumpGame.canJump(nums));
    }
}
