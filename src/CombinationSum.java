import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {

    static List<List<Integer>> solution = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        candidates = new int[]{2,3,6,7};
//        target = 7;
        recursion(candidates, 0, target, new LinkedList<>(), false);
        return solution;
    }

    private void recursion(int[] a, int i, int target, LinkedList<Integer> current, boolean recurred){
        if (target == 0 && !recurred){
            solution.add(new LinkedList<>(current));
            return;
        }
        if(i >= a.length || target < 0){
            return;
        }
        int currentElement = a[i];
        if (!recurred)
            recursion(a, i +1, target, current, false); //skip current
        current.addLast(a[i]);
        recursion(a, i+1, target- currentElement, current, false);
        recursion(a, i, target- currentElement, current, true);
        current.removeLast();

    }
}
