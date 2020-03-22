import java.util.*;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            if (newInterval.length == 0)
                return new int[0][0];
            else {
                int[][] temp = new int[1][2];
                temp[0] = newInterval;
                return temp;
            }
        }
        boolean hasStarted = false, newIntervalAdded =false;
        int newIntervalStart = newInterval[0];
        int newIntervalEnd = newInterval[1];
        int start=0, max=0;
        int i = 0;
        List<List<Integer>> newIntervals = new LinkedList<>();
        while (i < intervals.length){
            if (!hasStarted){
                hasStarted = true;
                if (!newIntervalAdded && newIntervalStart <= intervals[i][0]){
                    newIntervalAdded = true;
                    start = newIntervalStart;
                    max = newIntervalEnd;
                }else {
                    start = intervals[i][0];
                    max = intervals[i][1];
                    i++;
                }
            }else {
                if (!newIntervalAdded && newIntervalStart <= max){
                    newIntervalAdded = true;
                    max = Math.max(max, newIntervalEnd);
                }else if (intervals[i][0] <= max){
                    max = Math.max(intervals[i][1], max);
                    i++;
                }else{
                    newIntervals.add(Arrays.asList(start, max));
                    hasStarted = false;
                }
            }
        }
        if (!newIntervalAdded){
            if (newIntervalStart <= max){
                max = Math.max(newIntervalEnd, max);
            }else {
                newIntervals.add(Arrays.asList(start, max));
                start = newIntervalStart;
                max = newIntervalEnd;
            }
        }
        newIntervals.add(Arrays.asList(start, max));
        int[][] answer = new int[newIntervals.size()][2];
        for (int j = 0; j < newIntervals.size(); j++) {
            answer[j][0] = newIntervals.get(j).get(0);
            answer[j][1] = newIntervals.get(j).get(1);
        }
        return answer;
    }
}
