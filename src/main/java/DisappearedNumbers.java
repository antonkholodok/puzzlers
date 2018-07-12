import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array),
 * some elements appear twice and others appear once.
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * Could you do it without extra space and in O(n) runtime?
 * You may assume the returned list does not count as extra space.
 * <p>
 * Example:
 * Input: [4,3,2,7,8,2,3,1]
 * Output: [5,6]
 */
public class DisappearedNumbers {

    public static List<Integer> solve(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        return IntStream.range(0, nums.length)
            .filter(i -> nums[i] > 0)
            .mapToObj(i -> i + 1)
            .collect(Collectors.toList());
    }

}
