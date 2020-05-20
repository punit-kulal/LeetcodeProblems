import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LCMayChallenge {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length > 2) {
            double slope = Double.POSITIVE_INFINITY;
            if (coordinates[0][0] - coordinates[1][0] != 0) {
                slope = ((double) (coordinates[0][1] - coordinates[1][1])) / ((double) (coordinates[0][0] - coordinates[1][0]));
            }
            for (int i = 2; i < coordinates.length; i++) {
                double currentSlope = Double.POSITIVE_INFINITY;
                if (coordinates[0][0] - coordinates[i][0] !=0) {
                    currentSlope = ((double) (coordinates[0][1] - coordinates[i][1])) / ((double) (coordinates[0][0] - coordinates[i][0]));
                }
                if (slope != currentSlope) {
                    return false;
                }
            }
        }
        return true;
    }

    public int findJudge(int N, int[][] trust) {
        if (trust.length == 0 && N == 1){
            return 1;
        }
        Map<Integer, Set<Integer>> map  = new HashMap<>();
        Set<Integer> trusting = new HashSet<>();
        for (int[] t : trust) {
            Set<Integer> s = map.getOrDefault(t[1], new HashSet<>());
            trusting.add(t[0]);
            s.add(t[0]);
            map.put(t[1], s);
        }
        for (Map.Entry<Integer, Set<Integer>> entry: map.entrySet()) {
            if (entry.getValue().size() == N-1 && !trusting.contains(entry.getKey())){
                return entry.getKey();
            }
        }
        return -1;
    }
}
