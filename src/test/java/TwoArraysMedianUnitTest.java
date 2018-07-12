import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.IntStream;

@RunWith(Parameterized.class)
public class TwoArraysMedianUnitTest {

    @Parameterized.Parameters
    public static Collection<Object> data() {
        return Arrays.asList(new Object[][]{
            {IntStream.of(1, 2).toArray(), IntStream.of(2).toArray(), 2.0},
            {IntStream.of(1, 2).toArray(), IntStream.of(3, 4).toArray(), 2.5},
            {IntStream.of(1).toArray(), IntStream.of(3).toArray(), 2.0},
        });
    }

    private final int[] a;
    private final int[] b;
    private final double median;

    public TwoArraysMedianUnitTest(int[] a, int[] b, double median) {
        this.a = a;
        this.b = b;
        this.median = median;
    }

    @Test
    public void test() {
        TestCase.assertEquals(median, TwoArraysMedian.median(a, b));
    }
}
