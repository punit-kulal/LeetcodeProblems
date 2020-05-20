import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {

    static Map<Integer, Integer> count = new HashMap<>();

    public int countNodes(TreeNode root) {
        int height = 1;
        TreeNode temp = root;
        count.put(1, 1);
        while (temp.left != null) {
            count.put(height + 1, 2 * height + 1);
            height++;
            temp = temp.left;
        }
        return getCount(root);
    }

    private int getCount(TreeNode t) {
        if (t == null) {
            return 0;
        }
        TreeNode temp = t;
        int left = 1, right = 1;
        while (temp.left != null) {
            left++;
            temp = temp.left;
        }
        temp = t;
        while (temp.right != null) {
            right++;
            temp = temp.right;
        }

        if (left == right) {
            return count.get(left);
        } else {
            return getCount(t.left) + getCount(t.right) + 1;
        }

    }

    public int rangeBitwiseAnd(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        } else {
            int counter = 0;
            Stack<Integer> stack = new Stack<>();
            Stack<Integer> stack2 = new Stack<>();
            while (m != 0 && n != 0) {
                stack.push(m % 2);
                stack2.push(n % 2);
                m = m / 2;
                n = n / 2;
                counter++;
            }
            if (m != n) {
                return 0;
            } else {
                int ans = 0;
                boolean flag = true;
                while (stack.size() != 0) {
                    int x = stack.pop();
                    int y = stack2.pop();
                    if (x == y && flag) {
                        if (x == 1)
                            ans += 1;
                        ans = ans * 2;
                    } else {
                        flag = false;
                        ans = ans * 2;
                    }
                }
                return ans;
            }

        }

    }
}