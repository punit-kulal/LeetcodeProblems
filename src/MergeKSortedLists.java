import java.util.PriorityQueue;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<NodeWrapper> heap = new PriorityQueue<>();
        for (int i =0; i < lists.length; i++){
            heap.add(new NodeWrapper(lists[i], i));
        }
        ListNode head = null;
        ListNode current = null;
        while (heap.size() != 0){
            NodeWrapper next = heap.poll();
            if (next != null) {
                addListToHeap(next.list, lists, heap);
                if (head == null) {
                    head = next.node;
                    current = next.node;
                } else {
                    current.next = next.node;
                    current = next.node;
                }
            }
        }
        return head;
    }

    private void addListToHeap(int index, ListNode[] lists, PriorityQueue<NodeWrapper> heap) {
        if (lists[index].next != null){
            heap.add(new NodeWrapper(lists[index].next, index));
            lists[index] = lists[index].next;
        }
    }
}

class NodeWrapper implements Comparable<NodeWrapper>{
    public ListNode node;
    public int list;

    public NodeWrapper(ListNode node, int list){
        this.list = list;
        this.node = node;
    }

    @Override
    public int compareTo(NodeWrapper o) {
        return this.node.val - o.node.val;
    }
}
