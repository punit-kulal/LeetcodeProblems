import java.util.HashMap;
import java.util.Stack;

public class ContiguousSubArray {
    public int findMaxLength(int[] nums) {
        if (nums.length<2){
            return 0;
        }
        int sum = 0;
        int max = 0;
        HashMap<Integer,Integer> min = new HashMap<>();
        min.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0){
                sum--;
            }else {
                sum++;
            }
            if (min.containsKey(sum)){
                max = Math.max(max, min.get(sum));
            }else{
                min.put(sum, i-1);
            }
        }
        return  max;
    }
}
