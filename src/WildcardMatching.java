class WildcardMatching {

    static int[][] dp;

    public boolean isMatch(String s, String p) {
        s = "";
        p = "**";
        if(s.length() == 0 && p.length() == 0){
            return true;
        }
        if (p.length() == 0){
            return false;
        }
        if (s.length() == 0){
            for(char c:s.toCharArray()){
                if (c != '*'){
                    return false;
                }
            }
            return true;
        }
        char[] sarray = s.toCharArray();
        char[] parray = p.toCharArray();
        dp = new int[sarray.length][parray.length];

        System.out.println(recursion(dp, sarray, parray, 0, 0));
        return recursion(dp, sarray, parray, 0, 0);
    }

    public boolean recursion(int[][] dp, char[] s, char[] p, int sIndex, int pIndex){
        if (pIndex == p.length){
            return sIndex == s.length;
        }

        if (dp[sIndex][pIndex] == 1)
            return true;
        if (dp[sIndex][pIndex] == 2)
            return false;
        if (p[pIndex] == '?'){
            if (recursion(dp, s, p, sIndex+1, pIndex+1)){
                dp[sIndex][pIndex] = 1;
                return true;
            }else{
                dp[sIndex][pIndex] = 2;
                return false;
            }
        }
        if (p[pIndex] == '*'){
            if (recursion(dp, s, p, sIndex, pIndex+1) || recursion(dp, s, p, sIndex+1, pIndex+1) ||
                    recursion(dp, s, p, sIndex+1, pIndex)){
                dp[sIndex][pIndex] = 1;
                return true;
            }else{
                dp[sIndex][pIndex] = 2;
                return false;
            }
        }
        if (p[pIndex] == s[sIndex]){
            if (recursion(dp, s, p, sIndex + 1, pIndex + 1)){
                dp[sIndex][pIndex] = 1;
                return true;
            }else{
                dp[sIndex][pIndex] = 2;
                return false;
            }
        }
        return false;
    }
}