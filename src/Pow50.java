public class Pow50 {

    public double myPow(double x, int n) {
        double current = x;
        int currentN = n;
        double total = 1;
        while(currentN != 0){
            if (currentN%2 == 1){
                total *= current;
            }else if(currentN%2 == -1) {
                total /= current;
            }
            current = current*current;
            currentN = currentN/2;
        }
        return total;
    }
}
