/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 * ---------------
 * Example 1:
 * Input: 123
 * Output: 321
 * ---------------
 * Example 2:
 * Input: -123
 * Output: -321
 * ---------------
 * Example 3:
 * Input: 120
 * Output: 21
 * ---------------
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range:
 * [−2^31,  2^31 − 1].
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */
public class ReverseInteger {

    public static int reverse(int x) {
        long result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x /= 10;
            if ((int) result != result) {
                return 0;
            }
        }
        return (int) result;
    }

    public static int reverse2(int x) {
        int result = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && pop > 7) ||
                result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            result = result * 10 + pop;
        }
        return result;
    }
}
