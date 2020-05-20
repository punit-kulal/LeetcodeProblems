import java.util.Arrays;
import java.util.Scanner;

public class CandidateCode2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int i = 0; i < T; i++) {
            int N  = s.nextInt();
            long[] arr1 = new long[N];
            long[] arr2 = new long[N];
            for (int j = 0; j < N; j++) {
                arr1[j] = s.nextLong();
            }
            for (int j = 0; j < N; j++) {
                arr2[j] = s.nextLong();
            }
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            int i1 = 0;
            int i2 = 0;
            int v = 0;
            while(i1 < N){
                if (arr1[i1] > arr2[i2]){
                    v++;
                    i1++;
                    i2++;
                }else{
                    i1++;
                }
            }
            System.out.println(v);
        }
    }
}
