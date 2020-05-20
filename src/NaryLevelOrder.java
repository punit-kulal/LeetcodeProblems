import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NaryLevelOrder {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> answer = new ArrayList<>();
        recursion(root, 0, answer);
        return answer;
    }

    private void recursion(Node root, int i, List<List<Integer>> answer) {
        if (root==null)
            return;
        if (i>=answer.size()){
            answer.add(new LinkedList<>());
        }
        List<Integer> level = answer.get(i);
        level.add(root.val);
        for (Node n : root.children) {
            recursion(n, i + 1, answer);
        }
    }
}
