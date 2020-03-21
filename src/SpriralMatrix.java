import java.util.LinkedList;
import java.util.List;

public class SpriralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiralOrder = new LinkedList<>();
        int i,j, top,left,bottom, right, m, n, count;
        i = top = left = bottom = right = count = 0;
        m = matrix.length;
        if (m == 0){
            return spiralOrder;
        }else{
            n = matrix[0].length;
        }
        j =-1;
        while (count < m*n){

            while (j < n - right && count < m*n){
                spiralOrder.add(matrix[i][++j]);
                count++;
            }
            top++;

            while (i < m - bottom && count < m*n){
                spiralOrder.add(matrix[++i][j]);
                count++;
            }
            right++;

            while ( j > left && count < m*n){
                spiralOrder.add(matrix[i][--j]);
                count++;
            }

            bottom++;

            while ( i > top && count < m*n){
                spiralOrder.add(matrix[--i][j]);
                count++;
            }
            left++;

        }
        return spiralOrder;
    }
}
