import java.util.*;

public class LC207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Set<Integer> visited = new HashSet<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : prerequisites) {
            List<Integer> to = graph.getOrDefault(edge[0], new ArrayList<>());
            to.add(edge[1]);
            graph.put(edge[0], to);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!visited.contains(i)) {
                if (isCyclic(i, new HashSet<>(), visited, graph)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isCyclic(int i, Set<Integer> explore, Set<Integer> visited, Map<Integer, List<Integer>> graph) {
        if (explore.contains(i)) {
            return true;
        } else {
            visited.add(i);
            List<Integer> dependencyList = graph.get(i);
            if(dependencyList == null){
                return false;
            }
            explore.add(i);
            for (Integer d : dependencyList) {
                if (isCyclic(d, explore, visited, graph)) {
                    return true;
                }
            }
            explore.remove(i);
        }
        return false;
    }
}
