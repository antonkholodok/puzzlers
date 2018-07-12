import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;

@RunWith(Parameterized.class)
public class DisappearedNumbersUnitTest {

    @Parameterized.Parameters
    public static Collection<Object> data() {
        return Arrays.asList(new Object[][]{
            {IntStream.of(4, 3, 2, 7, 8, 2, 3, 1).toArray(), Arrays.asList(5, 6)}
        });
    }

    private final int[] nums;
    private final List<Integer> missing;

    public DisappearedNumbersUnitTest(int[] nums, List<Integer> missing) {
        this.nums = nums;
        this.missing = missing;
    }

    @Test
    public void test() {
        TestCase.assertEquals(missing, DisappearedNumbers.solve(nums));
    }
}
