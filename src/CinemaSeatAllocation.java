import java.util.Arrays;
import java.util.Comparator;

public class CinemaSeatAllocation {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Arrays.sort(reservedSeats, Comparator.comparingInt(o -> o[0]));
        if (reservedSeats.length == 0){
            return n*2;
        }
        int reservedSeatsIndex = 0;
        int totalCount = 0;
        int prevBlocked = 0;
        int currentBlocked;
        while (reservedSeatsIndex < reservedSeats.length){
            currentBlocked = reservedSeats[reservedSeatsIndex][0];
            totalCount += (currentBlocked-1 - prevBlocked)*2;
            prevBlocked = currentBlocked;
            boolean[] row = new boolean[10];
            int count = 0;
            while (reservedSeatsIndex < reservedSeats.length 
                    && reservedSeats[reservedSeatsIndex][0] == currentBlocked){
                row[reservedSeats[reservedSeatsIndex][1] - 1] = true;
                reservedSeatsIndex++;
            }

            if (!(row[2] || row[3] || row[4] || row[1])){
                count++;
            }

            if(!(row[5] || row[6] || row[7] || row[8])){
                count++;
            }
            if (!(row[6] || row[3] || row[4] || row[5]) && count == 0){
                count++;
            }
            totalCount += count;
        }
        totalCount += (n - 1 - prevBlocked)*2;
        return totalCount;
    }
}
