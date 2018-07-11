import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.IntStream;

@RunWith(Parameterized.class)
public class SingleElementInSortedArrayUnitTest {

    @Parameterized.Parameters
    public static Collection<Object> data() {
        return Arrays.asList(new Object[][] {
            { IntStream.of(1, 1, 2).toArray(), 2 },
            { IntStream.of(1, 1, 2, 2, 4, 4, 5, 5, 9).toArray(), 9 }
        });
    }

    public final int[] nums;
    public final int expected;

    public SingleElementInSortedArrayUnitTest(int[] nums, int expected) {
        this.nums = nums;
        this.expected = expected;
    }

    @Test
    public void test() {
        TestCase.assertEquals(expected, SingleElementInSortedArray.singleNonDuplicate(nums));
    }
}
