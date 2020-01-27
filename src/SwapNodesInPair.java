public class SwapNodesInPair {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public ListNode swapPairs(ListNode head) {
        ListNode one=null, two=null, three=null, four=null;
        one = head;
        if (head != null && head.next != null)
            two = head.next;
        if (two != null && two.next != null)
            three = two.next;

        if (one != null && two != null){
            one.next = two.next;
            two.next = one;
            head = two;
            two = one;
        }

        while(two != null && two.next !=null && two.next.next != null){
            three = two.next;
            four = two.next.next;
            two.next = four;
            three.next = four.next;
            four.next = three;
            two = three;
        }
        return head;
    }
}
