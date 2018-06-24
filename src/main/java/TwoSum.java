import java.util.Arrays;

public class TwoSum {

    public static boolean solve(int[] nums, int target) {

        Arrays.sort(nums);

        for (int i = 0, j = nums.length - 1; i < j; ) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                return true;
            }
            if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}
