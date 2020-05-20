import java.util.Arrays;

public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        if (t.length() == 0){
            return 1;
        }
        if (s.length() == 0){
            return 0;
        }

        int[][] dp = new int[t.length()+1][s.length()+1];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i < t.length() + 1; i++) {
            for (int j = i; j < s.length() + 1; j++) {
                if (s.charAt( j - 1) == t.charAt(i - 1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
                }else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[t.length()][s.length()];

    }

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(maxChoosableInteger*(maxChoosableInteger-1)/2 < desiredTotal){
            return false;
        }
        if (maxChoosableInteger%2 == 0 && desiredTotal%(maxChoosableInteger+1) == 0){
            return false;
        }
        if (maxChoosableInteger%2 == 1 && desiredTotal == maxChoosableInteger + 1){
            return  false;
        }
        return true;
    }
}
