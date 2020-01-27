public class DecodeWays {

    static int mod = 1000000007;

    public static int numDecodings(String s) {
        char[] arr = s.toCharArray();
        int[] sum = new int[arr.length+1];
//        if (arr[0] == '0' ){
//            sum[0] = 0;
//        }else if (arr[0] == '*'){
//            sum[0] = 9;
//        }else{
//            sum[0] = 1;
//        }
        sum[0] = arr[0] == '0'?0:1;
        for (int i = 1; i <= arr.length; i++){
            int sum2=0;
            if (i >= 2){
                if (arr[i-2] == '0'){
                    sum2 = 0;
                }else if (arr[i-2] == '*'){
                    if (arr[i-1] == '*'){
                        sum2 = (sum[i-2]*15)%mod;
                    }
                    else if (Character.getNumericValue(arr[i-1]) < 7){
                        sum2 = (sum[i-2]*2)%mod;
                    }
                    else{
                        sum2 = sum[i-2];
                    }
                }else{
                    if (arr[i-1] == '*') {
                        if (Character.getNumericValue(arr[i-2]) == 1){
                            sum2 = (sum[i-2]*9)%mod;
                        }else if (Character.getNumericValue(arr[i-2]) == 2){
                            sum2 = (sum[i-2]*6)%mod;
                        }
                    }else{
                        sum2 = Character.getNumericValue(arr[i-2])*10 + Character.getNumericValue(arr[i-1]) <= 26 ?sum[i-2]:0;
                    }
                }
            }
            int sum1 = (arr[i-1] == '0')?0:sum[i-1];
           sum1 =  arr[i-1] == '*'? (sum1*9)%mod:sum1;
           sum[i] = (sum1 + sum2)%mod;
        }
        return sum[sum.length-1];
    }

    public static void main(String[] args){
        System.out.println(numDecodings("1*"));
    }

}
