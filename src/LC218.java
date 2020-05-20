import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class LC218 {

    public static void main(String[] args) {
        int[][] p = {{2,4,70},{3,8,30},{6,100,41},{7,15,70},{10,30,102},{15,25,76},{60,80,91},{70,90,72},{85,120,59}};
        getSkyline(p);
    }

    public static List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> answer = new LinkedList<>();
        PriorityQueue<BuildingNode> heap = new PriorityQueue<>();
        for (int i = 0; i < buildings.length; i++) {
            int[] p = buildings[i];
            BuildingNode node = new BuildingNode(p[0], p[1], p[2]);
            heap.add(node);
        }
        if (heap.size() == 0)
            return answer;
        BuildingNode b = heap.poll();
        int s=b.start, e=b.end, h = b.height;
        answer.add(Arrays.asList(s, h));
        while(heap.size() != 0){
            BuildingNode c = heap.poll();
            if (c.start > s){
                if (c.start < e){
                    if(c.height > h){
                        if (c.end > e){
                            e = c.end;
                        }else if(e > c.end){
                            heap.add(new BuildingNode(c.end, e, h));
                        }
                        answer.add(Arrays.asList(c.start, c.height));
                        s = c.start;
                        e = c.end;
                        h = c.height;
                    }else{
                        if (c.end > e){
                            heap.add(new BuildingNode(e, c.end, c.height));
                        }
                    }

                }else if (e == c.start){
                    s = c.start;
                    e = c.end;
                    if (h != c.height){
                        h = c.height;
                        answer.add(Arrays.asList(c.start, h));
                    }
                }else{
                    answer.add(Arrays.asList(e, 0));
                    s = c.start;
                    e = c.end;
                    h = c.height;
                    answer.add(Arrays.asList(s, h));
                }
            }
            else if (c.start == s){
                if(c.end > e){
                    heap.add(new BuildingNode(e, c.end, c.height));
                }
            }else{
                throw new IllegalStateException("should not happen");
            }
        }
        answer.add(Arrays.asList(e, 0));
        return answer;
    }
}

class BuildingNode implements Comparable<BuildingNode>{

    int start;
    int end;
    int height;

    public BuildingNode(int start, int end, int height) {
        this.start = start;
        this.end = end;
        this.height = height;
    }

    @Override
    public int compareTo(BuildingNode o) {
        return (start != o.start)?start-o.start: o.height-height;
    }
}