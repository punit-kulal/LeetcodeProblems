public class Permutation {

    static long m = 1000000007;

    static int permute(int n, int i){
        return 1;
    }

    static long combination(int n, int i){
        return factorial(n)/((factorial(i))*(factorial(n-i)));
    }

    static  long factorial(int n){
        if (n ==1)
            return 1;
        return ((n%m)*(factorial(n-1)%m))%m;
    }
}
