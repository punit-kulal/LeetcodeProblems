import java.util.*;

public class LC187 {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> answer = new LinkedList<>();
        Map<String, Integer> patterns = new HashMap<>();
        for (int i = 0; i < s.length() - 10; i++) {
            String subPattern = s.substring(i, i + 10);
            patterns.computeIfPresent(subPattern, (k, v) -> v + 1);
            patterns.putIfAbsent(subPattern, 1);
        }
        patterns.forEach((k, v) -> {
            if (v > 1) {
                answer.add(k);
            }
        });
        return answer;
    }
}
