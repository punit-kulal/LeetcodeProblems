import java.util.LinkedList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        List<List<Integer>> solution = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        recursions(nums, visited, list, solution);
        return solution;
    }

    public void recursions(int[] nums, boolean[] visited, LinkedList<Integer> current, List<List<Integer>> solution){
        if (current.size() == nums.length){
            solution.add(new LinkedList<>(current));
        }else{
            for (int i = 0; i < nums.length; i++){
                if (!visited[i]){
                    current.addLast(nums[i]);
                    visited[i] = true;
                    recursions(nums, visited, current, solution);
                    current.removeLast();
                    visited[i] = false;
                }
            }
        }
    }


}
