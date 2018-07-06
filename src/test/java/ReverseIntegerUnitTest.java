import junit.framework.TestCase;
import org.junit.Test;

public class ReverseIntegerUnitTest {

    @Test
    public void testReverseRegular() {
        TestCase.assertEquals(321, ReverseInteger.reverse(123));
    }

    @Test
    public void testReverse2Regular() {
        TestCase.assertEquals(321, ReverseInteger.reverse2(123));
    }

    @Test
    public void testReverseNegative() {
        TestCase.assertEquals(-321, ReverseInteger.reverse(-123));
    }

    @Test
    public void testReverse2Negative() {
        TestCase.assertEquals(-321, ReverseInteger.reverse2(-123));
    }

    @Test
    public void testReverseOverflow() {
        TestCase.assertEquals(0, ReverseInteger.reverse(1534236469));
    }

    @Test
    public void testReverse2Overflow() {
        TestCase.assertEquals(0, ReverseInteger.reverse2(1534236469));
    }

    @Test
    public void testReverseUnderflow() {
        TestCase.assertEquals(0, ReverseInteger.reverse(-1534236469));
    }

    @Test
    public void testReverse2Underflow() {
        TestCase.assertEquals(0, ReverseInteger.reverse2(-1534236469));
    }

    @Test
    public void testReverseAroundMinInteger() {
        TestCase.assertEquals(Integer.MIN_VALUE + 7, ReverseInteger.reverse(-1463847412));
    }

    @Test
    public void testReverse2AroundMinInteger() {
        TestCase.assertEquals(Integer.MIN_VALUE + 7, ReverseInteger.reverse2(-1463847412));
    }

    @Test
    public void testReverseAroundMaxInteger() {
        TestCase.assertEquals(Integer.MAX_VALUE - 6, ReverseInteger.reverse(1463847412));
    }

    @Test
    public void testReverse2AroundMaxInteger() {
        TestCase.assertEquals(Integer.MAX_VALUE - 6, ReverseInteger.reverse2(1463847412));
    }
}
