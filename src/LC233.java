import java.util.HashMap;
import java.util.Map;

public class LC233 {

    static Map<Integer, Integer> map = new HashMap<>();
    public int countDigitOne(int n) {
        int remainder=0, multiplier=1,current = 0, count = 0;
        while(n != 0){
            current = n%10;
            if (current == 0){

            }else if (current == 1){
                count += getMultiplier(multiplier) + remainder+1;
            }else{
                count += current*getMultiplier(multiplier) + multiplier;
            }
            remainder = remainder + current*multiplier;
            n = n/10;
            multiplier = multiplier*10;
        }
        return count;
    }

    private int getMultiplier(int n){
        if (!map.containsKey(n)){
            int answer = 0;
            if (n != 1) {
                answer = 10*getMultiplier(n/10) + n/10;
            }
            map.put(n, answer);
        }
        return map.get(n);
    }
}
