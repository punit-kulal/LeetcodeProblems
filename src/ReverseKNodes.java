class ReverseKNodes {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k ==1){
            return head;
        }
        ListNode x = new ListNode(0);
        ListNode prev_tail = x;
        x.next = head;

        ListNode temp, temp1,temp2=null;
        while (doesNextKNodeExist(head, k)){
            temp1 = head;
            if (head != null && head.next != null){
                temp2 = head.next;
            }
            int count = 1;
            while (count < k){
                temp = temp2.next;
                temp2.next = temp1;
                temp1 = temp2;
                temp2 = temp;
                count++;
            }
            if (prev_tail != null)
                prev_tail.next = temp1;
            else
                throw new IllegalStateException();
            prev_tail = head;
            if (prev_tail != null){
                prev_tail.next = temp2;
            }
            head = temp2;


        }
        return x.next;
    }

    private boolean doesNextKNodeExist(ListNode current, int k){
        int counter = 1;
        while(counter < k){
            if (current == null || current.next == null){
                return false;
            }
            current = current.next;
            counter++;
        }
        return true;
    }


}
