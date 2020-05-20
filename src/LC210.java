import java.util.*;

public class LC210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer,Set<Integer>> graph = new HashMap<>();
//        boolean[][] graph = new boolean[numCourses][numCourses];
        Set<Integer> inKeys = new HashSet<>();
        for (int[] p: prerequisites) {
            graph.computeIfAbsent(p[1], k -> new HashSet<>()).add(p[0]);
            inKeys.add(p[0]);
        }
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (!visited.contains(i)) {
                if (graph.containsKey(i)) {
                    try {
                        dfs(graph, stack, visited, i, new HashSet<>());
                    }catch (IllegalStateException illegalStateException){
                        return new int[0];
                    }
                } else if (!inKeys.contains(i)) {
                    stack.add(i);
                    visited.add(i);
                }
            }
        }
        int[] answer = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            answer[i] = stack.pop();
        }
        return answer;
    }

    private void dfs(Map<Integer, Set<Integer>> graph, Stack<Integer> stack, Set<Integer> visited, int i, Set<Integer> recursion) {
        if (recursion.contains(i)){
            throw new IllegalStateException("cycle");
        }
        if (visited.contains(i)){
            return;
        }
        Set<Integer> x = graph.get(i);
        visited.add(i);
        if (x != null){
            recursion.add(i);
            for (Integer n : x) {
                dfs(graph, stack, visited, n, recursion);
            }
            recursion.remove(i);
        }
        stack.push(i);
    }
}
