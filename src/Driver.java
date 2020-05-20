import java.util.List;

public class Driver {
    public static void main(String[] args) {
//        new TrappingRainWater().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
//        new TrapRainWater().trapRainWater(new int[][]{{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}});
//        runReverseKNodes();
//        System.out.println(new NumberOfIslands().numIslands());
    }


    static void runReverseKNodes() {
        ListNode current, head = new ListNode(1);
        current = head;
        int counter = 2;
        while (counter < 6) {
            current.next = new ListNode(counter);
            current = current.next;
            counter++;
        }
        new ReverseKNodes().reverseKGroup(head, 3);
    }
}
