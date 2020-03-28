import java.util.LinkedList;
import java.util.List;

public class PermutationSequence {


    public String getPermutation(int n, int k) {
        int[] factorial = new int[n+1];
        LinkedList<Integer> list = new LinkedList<>();
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = i* factorial[i-1];
            list.add(i);
        }
        return recurse(list, new LinkedList<>(), k, factorial);
    }

    private String recurse(LinkedList<Integer> list, LinkedList<Integer> answer, int k, int[] factorial){
        if (list.size() == 0){
            StringBuilder s = new StringBuilder();
            for (Integer a: answer){
                s.append(a);
            }
            return s.toString();
        }else {
            int i = 1;
            int n = list.size();
            while (i <= n){
                if (i*factorial[n-1] >= k){
                    answer.add(list.get(i-1));
                    list.remove(i-1);
                    return recurse(list, answer, k-(i-1)*factorial[n-1], factorial);
                }else {
                    i++;
                }
            }
        }
        return null;
    }

}
