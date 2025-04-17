package sit707_week6;

import org.junit.Assert;
import org.junit.Test;

public class LoopFunctionsTest {

    @Test
    public void testSumUpTo() {
        Assert.assertEquals(15, LoopFunctions.sumUpTo(5)); // 1+2+3+4+5
        Assert.assertEquals(0, LoopFunctions.sumUpTo(0));
    }

    @Test
    public void testCountEvenNumbers() {
        int[] input = {1, 2, 3, 4, 5, 6};
        Assert.assertEquals(3, LoopFunctions.countEvenNumbers(input));

        int[] empty = {};
        Assert.assertEquals(0, LoopFunctions.countEvenNumbers(empty));
    }
}
