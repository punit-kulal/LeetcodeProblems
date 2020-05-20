public class DiameterTree {
    public int diameterOfBinaryTree(TreeNode root) {
        return recurse(root)[1];
    }

    public int[] recurse(TreeNode node){
        if (node == null){
            return new int[]{0,0};
        }else{
            int[] left = recurse(node.left);
            int[] right = recurse(node.right);
            int max = Math.max(left[0], right[0]) +1;
            int currentMax = Math.max(Math.max(left[0]+right[0]+1, left[1]), right[1]);
            return new int[]{max, currentMax};
        }
    }
}


