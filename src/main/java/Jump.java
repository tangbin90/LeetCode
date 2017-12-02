package main.java;

import static java.lang.Math.min;

/**
 * @author TangBin
 * @version V1.0
 * @date 30/11/2017 8:18 PM
 */
public class Jump {
    public int jump(int[] nums) {
        if(nums.length<=1)
            return 0;

        int[] pathStore=new int[nums.length];
        pathStore[nums.length-1]=0;
        for(int i=0;i<nums.length-1;i++)
            pathStore[i]=-1;

        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]==0){
                continue;
            }
            if(nums[i]+i>=nums.length-1)
                pathStore[i]=1;
            else{
                int partMinPath = nums.length;
                for(int j=i+1;j<=i+nums[i]&&j<nums.length;j++){
                    if(pathStore[j]==-1)
                        continue;
                    int tempPath=pathStore[j]+1;
                    if(tempPath==2){
                        partMinPath=2;
                        break;
                    }
                    if(partMinPath>tempPath)
                        partMinPath=tempPath;
                }
                if(partMinPath==nums.length)
                    continue;
                pathStore[i]=partMinPath;
            }

        }

        return pathStore[0];
    }

    public static void main(String[] args){
        int[] nums=new int[]{2,3,3,1,0,0};
        Jump jump = new Jump();
        int path=jump.jump(nums);
        System.out.println(path);
    }
}
