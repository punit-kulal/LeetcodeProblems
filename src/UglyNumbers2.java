import java.util.ArrayList;
import java.util.List;

public class UglyNumbers2 {
    static List<Integer> uglyNumbers = new ArrayList<>();

    public int nthUglyNumber(int n) {
        if (uglyNumbers.size() < 1690){
            uglyNumbers.add(1);
            int current = 2;
            while (uglyNumbers.size() <= 1690){
                int temp = current;
                while (temp!=1){
                    int prev_temp = temp;
                    if (temp%2==0){
                        temp = temp/2;
                    }
                    if (temp%3==0){
                        temp = temp/3;
                    }
                    if (temp%5==0){
                        temp = temp/5;
                    }
                    if (prev_temp == temp){
                        break;
                    }
                }
                if (temp == 1){
                    uglyNumbers.add(current);
                }
                current++;
            }

        }
        return uglyNumbers.get(n-1);

    }
}
