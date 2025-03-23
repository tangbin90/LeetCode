import leetcodesolutions.NO42_TrappingRainWater;
import org.junit.Assert;
import org.junit.Test;

public class TrappingRainWaterTest {
    @Test
    public void trap() throws Exception {
        NO42_TrappingRainWater trappingRainWater = new NO42_TrappingRainWater();
        int[] heights = new int[]{9,6,8,8,5,6,3};
        Assert.assertEquals(3,trappingRainWater.trap(heights));
    }

}