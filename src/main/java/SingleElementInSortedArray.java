/**
 * Given a sorted array consisting of only integers where every element appears
 * twice except for one element which appears once.
 * Find this single element that appears only once.
 *
 * Example 1:
 * Input: [1,1,2,3,3,4,4,8,8]
 * Output: 2
 * Example 2:
 * Input: [3,3,7,7,10,11,11]
 * Output: 10
 *
 * Note: Your solution should run in O(log n) time and O(1) space.
 */
public class SingleElementInSortedArray {

    public static int singleNonDuplicate(int[] nums) {

        int start = 0;
        int end = nums.length - 1;

        while (start < end) {

            int center = start + (end - start) / 2;

            if (nums[center] == nums[center - 1]) {
                if ((center - start + 1) % 2 == 1) {
                    end = center - 2;
                } else {
                    start = center + 1;
                }
            } else if (nums[center] == nums[center + 1]) {
                if ((end - center + 1) % 2 == 1) {
                    start = center + 2;
                } else {
                    end = center - 1;
                }
            } else {
                return nums[center];
            }
        }
        return nums[start];
    }
}
