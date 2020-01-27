import java.io.*;
import java.util.*;

public class MinJumps {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i=0; t_i<T; t_i++)
        {   String[] arr_ =  br.readLine().split(" ");
            int Array[] = new int[4];
            for(int i=0;i<4;i++){
                Array[i] = Integer.parseInt(arr_[i]);
            }
            int X = Array[0];
            int N = Array[1];
            int k1 = Array[2];
            int k2 = Array[3];
            String[] arr_arr = br.readLine().split(" ");
            int[] arr = new int[N];
            for(int i_arr=0; i_arr<arr_arr.length; i_arr++)
            {
                arr[i_arr] = Integer.parseInt(arr_arr[i_arr]);
            }
            int out_ = minimumJumps(X, arr, k1, k2);
            if(out_==0) System.out.println("no") ;
            else
            {  System.out.println("yes") ;
                System.out.println(out_);
            }
        }
        wr.close();
        br.close();
    }
    static int minimumJumps(int X, int[] arr, int k1, int k2){
        // Write your code here
        // Return 0 if you want to print "no" else return minimum jumps to reach X
        int[] hopcost = new int[X+k1];
        Arrays.fill(hopcost, Integer.MAX_VALUE);
        for(int element: arr){
            hopcost[element] = -1;
        }
        populateHopCost(0, 0, true, k1, k2, hopcost, X);
        return hopcost[X];
    }

    static void populateHopCost(int current, int hopCount, boolean backward, int k1, int k2, int[] hopCost, int target){
        if((current >= target+k1) || (backward && current >= target)){
            return ;
        }
        if(hopCost[current] < hopCount){
            return;
        }
        hopCost[current] = hopCount;
        hopCount++;
        populateHopCost(current+k1, hopCount, false, k1, k2, hopCost, target);
        if(!backward)
            populateHopCost(current-k2, hopCount, true, k1, k2, hopCost, target);
    }
}