import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node.
 */
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }

class Solution {

    static Map<Integer, Integer> count = new HashMap<>();

    public int countNodes(TreeNode root) {
        int height = 1;
        TreeNode temp = root;
        count.put(1, 1);
        while(temp.left !=null){
            count.put(height+1, 2*height+1);
            height++;
            temp = temp.left;
        }
        return getCount(root);
    }

    private int getCount(TreeNode t){
        if(t == null) {
            return 0;
        }
        TreeNode temp = t;
        int left = 1 , right = 1;
        while (temp.left != null){
            left++;
            temp = temp.left;
        }
        temp = t;
        while (temp.right != null){
            right++;
            temp = temp.right;
        }

        if (left == right){
            return count.get(left);
        }else{
            return getCount(t.left) + getCount(t.right) + 1;
        }

    }
}