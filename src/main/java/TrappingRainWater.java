import java.util.*;

import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * @author: 17082720 tangbin
 * @create: 2017/11/29 10:03
 * @description:
 */
public class TrappingRainWater {
    public int trap(int[] height){
        if(height.length==0)
            return 0;
        int ans = 0;
        int[] leftmax = new int[height.length];
        int[] rightmax = new int[height.length];
        leftmax[0]=height[0];
        rightmax[height.length-1]=height[height.length-1];
        for(int i=1;i<height.length;i++){
            leftmax[i]=max(height[i],leftmax[i-1]);
        }

        for(int i=height.length-2;i>=0;i--){
            rightmax[i]=max(height[i],rightmax[i+1]);
        }

        for(int i=0;i<height.length;i++){
            ans+=min(leftmax[i],rightmax[i])-height[i];
        }
        return ans;
    }

}
