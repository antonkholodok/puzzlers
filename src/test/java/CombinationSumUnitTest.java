import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;

@RunWith(Parameterized.class)
public class CombinationSumUnitTest {

    @Parameterized.Parameters
    public static Collection<Object> data() {
        return Arrays.asList(new Object[][]{
            {IntStream.of(10, 1, 2, 7, 6, 1, 5).toArray(), 8,
                Arrays.asList(
                    Arrays.asList(1, 1, 6),
                    Arrays.asList(1, 2, 5),
                    Arrays.asList(1, 7),
                    Arrays.asList(2, 6))},
            {IntStream.of(2, 5, 2, 1, 2).toArray(), 5,
                Arrays.asList(
                    Arrays.asList(1, 2, 2),
                    Arrays.asList(5))}
        });
    }

    public final int[] nums;
    public final int target;
    public final List<List<Integer>> combinations;

    public CombinationSumUnitTest(int[] nums,
                                  int target,
                                  List<List<Integer>> combinations) {
        this.nums = nums;
        this.target = target;
        this.combinations = combinations;
    }

    @Test
    public void testCombinationSum() {
        TestCase.assertEquals(combinations, CombinationSum.solve(nums, target));
    }
}
