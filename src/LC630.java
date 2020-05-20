import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC630 {

    public static void main(String[] args) {
        int[][] s = {{1, 2}};
        System.out.println(scheduleCourse(s));
    }

    public static int scheduleCourse(int[][] courses) {
        int total = 0;
        Arrays.sort(courses, Comparator.comparingInt(a -> a[1]));
        PriorityQueue<LC630Node> queue = new PriorityQueue<>();
        for (int[] course : courses) {
            LC630Node node = new LC630Node(course[0], course[1]);
            if (total + course[0] <= course[1]){
                queue.add(node);
                total += node.time;
            }else {
                LC630Node pNode = queue.peek();
                if (pNode != null && pNode.time < node.time){
                    queue.remove();
                    queue.add(node);
                    total -= pNode.time - node.time;
                }
            }
        }
        return queue.size();
    }
}

class LC630Node implements Comparable<LC630Node> {
    public LC630Node(int time, int due) {
        this.time = time;
        this.due = due;
    }

    int time;
    int due;

    @Override
    public int compareTo(LC630Node o) {
        return o.time - time;
    }
}
