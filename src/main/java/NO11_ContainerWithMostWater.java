/**
 * @author TangBin
 * @version V1.0
 * @date 05/04/2017 3:24 PM
 */
public class NO11_ContainerWithMostWater {
    public int maxArea(int[] height) {
        int begin = 0;
        int end = height.length-1;
        int maxAera=0;
        while(begin!=end){

            maxAera=Math.max(Math.min(height[begin],height[end])*(end-begin),maxAera);
            if(height[begin]>height[end])
                end--;
            else if(height[begin]==height[end]){
                begin++;
                end--;
            }
            else
                begin++;
        }
        return maxAera;
    }

    public static void main(String... args){
        NO11_ContainerWithMostWater cwm = new NO11_ContainerWithMostWater();
        int[] height = {6,2,3,4,5,5,6};
        System.out.println(cwm.maxArea(height));
    }
}
