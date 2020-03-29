import java.util.LinkedList;
import java.util.List;

public class AllPossibleSubsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new LinkedList<>();
        List<Integer> temp = new LinkedList<>();
        recurse(answer, temp, nums, 0);
        return answer;
    }

    private void recurse(List<List<Integer>> answer, List<Integer> temp, int[] nums, int start) {
        if (start==nums.length){
            answer.add(new LinkedList<>(temp));
            return;
        }
        recurse(answer, temp, nums, start+1);
        temp.add(nums[start]);
        recurse(answer, temp, nums, start+1);
        temp.remove(temp.size()-1);
    }
}
