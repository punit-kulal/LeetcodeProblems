import java.util.AbstractMap;
import java.util.Map;

public class LC124OG {
    public int maxPathSum(TreeNode root) {
        return recursion(root)[0];
    }

    private int[] recursion(TreeNode root){
        if(root == null){
            return new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
        }else{
            int[] left, right;
            left = recursion(root.left);
            right = recursion(root.right);
            int current = Math.max(left[1], Math.max(right[1],0)) + root.val;
            int intermediateMax = Math.max(left[1], 0) + root.val + Math.max(right[1], 0);
            current += root.val;;
            int max = Math.max(intermediateMax, Math.max(left[0], right[0]));
            return new int[]{max, current};
        }
    }
}
