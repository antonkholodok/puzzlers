import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
