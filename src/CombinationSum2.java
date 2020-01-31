import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum2 {
    static List<List<Integer>> solution;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//        candidates = new int[]{2,3,6,7};
//        target = 7;
        Arrays.sort(candidates);
        solution = new LinkedList<>();
        recursion(candidates, 0, target, new LinkedList<>(), -1);
        return solution;
    }

    private void recursion(int[] a, int i, int target, LinkedList<Integer> current, int previousVal) {
        if (target == 0 && i >= a.length) {
            solution.add(new LinkedList<>(current));
            return;
        }
        if (i >= a.length || target < 0) {
            return;
        }
        int currentElement = a[i];
        if (previousVal != a[i])
            recursion(a, i + 1, target, current, previousVal); //skip current
        current.addLast(a[i]);
        recursion(a, i + 1, target - currentElement, current, a[i]);
//        recursion(a, i, target - currentElement, current, previousVal);
        current.removeLast();

    }
}
