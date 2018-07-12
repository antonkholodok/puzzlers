import java.util.Arrays;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 * Example 1: nums1 = [1, 3], nums2 = [2]. The median is 2.0
 * Example 2: nums1 = [1, 2], nums2 = [3, 4]. The median is (2 + 3)/2 = 2.5
 *
 * TODO: https://leetcode.com/articles/median-of-two-sorted-arrays - O(log(m+n)) complexity
 */
public class TwoArraysMedian {

    public static double median(int[] a, int[] b) {

        int count = a.length + b.length;
        int medianIndex = count / 2;

        int i = 0;
        int j = 0;

        int first = 0;
        int second = 0;

        while (i + j <= medianIndex) {
            first = second;
            if (i == a.length) {
                second = b[j++];
            } else if (j == b.length) {
                second = a[i++];
            } else if (a[i] < b[j]) {
                second = a[i++];
            } else {
                second = b[j++];
            }
        }

        if (count % 2 == 1) {
            return second;
        }
        return (double) (first + second) / 2;
    }
}
