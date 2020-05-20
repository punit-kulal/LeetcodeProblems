import java.util.*;

class BinaryMatrix {

    public int candy(int[] ratings) {
        int[] a = new int[ratings.length];

        for (int i = 0; i < ratings.length; i++) {
            if ((i==0 || ratings[i] <= ratings[i-1]) && ( i == ratings.length -1 || ratings[i] <= ratings[i+1])){
                a[i] = 1;
            }
        }

        for (int i = 0; i < ratings.length; i++) {
            if (a[i] == 0){
                if (i != 0 && ratings[i] > ratings[i-1]){
                    a[i] = a[i-1] +1;
                }else{
                    if (i != ratings.length-1 && a[i+1] != 0 && ratings[i] > ratings[i+1]){
                        int j = i+1;
                        while(j-1 >= 0 && ratings[j] < ratings[j-1]){
                            if (a[j-1] == 0){
                                a[j - 1] = a[j] + 1;
                            }else if(a[j-1] >= a[j] + 1){
                                break;
                            }else{
                                a[j-1] = a[j] + 1;
                            }
                            j--;
                        }
                    }
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < ratings.length; i++) {
            sum += a[i];
        }
        return sum;
    }
};
