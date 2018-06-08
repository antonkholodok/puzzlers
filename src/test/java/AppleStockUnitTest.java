import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.IntStream;

@RunWith(Parameterized.class)
public class AppleStockUnitTest {

    @Parameterized.Parameters
    public static Collection<Object> data() {
        return Arrays.asList(new Object[][] {
            { IntStream.of(10, 7, 5, 8, 11, 9).toArray(), 6 },
            { IntStream.of(15, 8, 5, 3, 1).toArray(), -2 }
        });
    }

    public final int[] prices;
    public final int profit;

    public AppleStockUnitTest(int[] prices,
                              int profit) {
        this.prices = prices;
        this.profit = profit;
    }

    @Test
    public void testGetMaxProfit() {
        TestCase.assertEquals(profit, AppleStock.getMaxProfit(prices));
    }

}
