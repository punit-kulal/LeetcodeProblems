import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix2 {

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int i,j, top,left,bottom, right, count;
        i = top = left = bottom = right = count = 0;
        if (n==0){
            return matrix;
        }
        j =-1;
        while (count < n*n){

            while (j < n - right && count < n*n){
                matrix[i][++j] = ++count;

            }
            top++;

            while (i < n - bottom && count < n*n){
                matrix[++i][j] = ++count;

            }
            right++;

            while ( j > left && count < n*n){
                matrix[i][--j] = ++count;
            }

            bottom++;

            while ( i > top && count < n*n){
                matrix[--i][j] = ++count;
            }
            left++;
        }
        return matrix;
    }
}
