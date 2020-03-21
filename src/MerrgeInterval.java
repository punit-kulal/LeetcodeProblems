import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MerrgeInterval {

    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0){
            return new int[0][0];
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int start = intervals[0][0];
        int max= intervals[0][1];
        List<List<Integer>> newIntervals = new ArrayList<>();
        for(int i = 1; i <  intervals.length; i++){
            int[] interval =intervals[i];
            if(start == Integer.MIN_VALUE){
                start = interval[0];
                max = interval[1];
            }else if (interval[0] <= max){
                max = Math.max(max, interval[1]);
            }else{
                newIntervals.add(Arrays.asList(start, max));
                start = interval[0];
                max = interval[1];
            }
        }
        newIntervals.add(Arrays.asList(start, max));
        int[][] answer = new int[newIntervals.size()][2];
        for (int i = 0; i < newIntervals.size(); i++) {
            answer[i][0] = newIntervals.get(i).get(0);
            answer[i][1] = newIntervals.get(i).get(1);
        }
        return answer;
    }

}
