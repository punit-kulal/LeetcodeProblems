import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        recursion(root, 0, answer);
        return answer;
    }

    private void recursion(TreeNode root, int i, List<List<Integer>> answer) {
        if (root==null)
            return;
        if (i>=answer.size()){
            answer.add(new LinkedList<>());
        }
        List<Integer> level = answer.get(i);
        level.add(root.val);
        recursion(root.left, i + 1, answer);
        recursion(root.right, i + 1, answer);
    }

}
