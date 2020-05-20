public class LC124 {

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect(Node root) {
        if (root != null) {
            recursion(root);
        }
        return root;
    }

    private void recursion(Node root){
        Node rootNext = root.next;
        Node nextChild = null;
        while (rootNext != null){
            if (rootNext.left != null ){
                nextChild  = rootNext.left;
                break;
            }
            if (rootNext.right != null){
                nextChild = rootNext.right;
            }
            rootNext = rootNext.next;
        }
        if (root.right != null){
            root.right.next = nextChild;
            recursion(root.right);
            if (root.left != null){
                root.left.next = root.right;
                recursion(root.left);
            }
        }else if(root.left != null){
            root.left.next = nextChild;
            recursion(root.left);
        }
    }

}
