public class InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {
        int c1=0,c2=0,c3=0;
        if (s1.length() + s2.length() != s3.length()){
            return false;
        }
        char[] x1,x2,x3;
        x1 = s1.toCharArray();
        x2 = s2.toCharArray();
        x3 = s3.toCharArray();
        int[][] dp = new int[x1.length+1][x2.length+2];

        return  recurse(x1,x2,x3, c1,c2,c3, dp);
    }

    private boolean recurse(char[] s1, char[] s2, char[]s3, int c1, int c2, int c3, int[][] dp) {
        int x1=c1, x2=c2;
        if(dp[c1][c2] == 1){
            return false;
        }
        while (c3 < s3.length){
            if (c1 == s1.length){
                while (c2 < s2.length){
                    if (s2[c2] != s3[c3]){
                        dp[x1][x2] = 1;
                        return false;
                    }
                    c2++;
                    c3++;
                }
                return true;
            }
            if (c2 == s2.length){
                while (c1 < s1.length){
                    if (s1[c1] != s3[c3]){
                        dp[x1][x2] = 1;
                        return false;
                    }
                    c1++;
                    c3++;
                }
                return true;
            }

            if (s1[c1] == s3[c3] && s2[c2] == s3[c3]){
                return recurse(s1,s2,s3,c1+1,c2,c3+1,dp) || recurse(s1,s2,s3,c1,c2+1,c3+1,dp);
            }
            if (s1[c1] == s3[c3]){
                c1++;
                c3++;
            }else if(s2[c2] == s3[c3]){
                c2++;
                c3++;
            }else {
                dp[x1][x2] = 1;
                return false;
            }
        }
        return true;
    }


}
