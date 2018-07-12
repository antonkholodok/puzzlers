import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given a collection of candidate numbers (candidates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 * Each number in candidates may only be used once in the combination.
 *
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 *
 * Example 1:
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [[1, 7], [1, 2, 5], [2, 6], [1, 1, 6]]
 *
 * Example 2:
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [[1,2,2], [5]]
 */
public class CombinationSum {

    public static List<List<Integer>> solve(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        searchTarget(candidates, target, 0, combination, result);
        return result;
    }

    private static void searchTarget(int[] candidates, int target, int index,
                              List<Integer> combination,
                              List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }

        if (target < 0) {
            return;
        }

        int previous = -1;
        for (int i = index; i < candidates.length; ++i) {
            if (previous != candidates[i]) {
                combination.add(candidates[i]);
                searchTarget(candidates, target - candidates[i], i + 1, combination, result);
                combination.remove(combination.size() - 1);
                previous = candidates[i];
            }
        }
    }
}
