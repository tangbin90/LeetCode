package leetcodesolutions;

import java.util.Arrays;

public class NO135_Candy {
    public static int candy(int[] ratings){
        int length = ratings.length;
        int[] nums = new int[length];
        Arrays.fill(nums, 1);

        for(int i=0; i<length-1; i++){
            if(ratings[i+1]> ratings[i]){
                nums[i+1] = Math.max(nums[i+1], nums[i]+1);
            }
        }

        for(int i=length-1; i>0; i--){
            if(ratings[i-1] > ratings[i]){
                nums[i-1] = Math.max(nums[i-1], nums[i]+1);
            }
        }

        int sum = 0;
        for(int n : nums){
            sum += n;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] ratings = {1,2,2};
        System.out.println(candy(ratings));
    }
}
