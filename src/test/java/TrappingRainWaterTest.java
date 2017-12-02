import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TrappingRainWaterTest {
    @Test
    public void trap() throws Exception {
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        int[] heights = new int[]{9,6,8,8,5,6,3};
        Assert.assertEquals(3,trappingRainWater.trap(heights));
    }

}