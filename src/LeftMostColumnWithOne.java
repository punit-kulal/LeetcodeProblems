import java.util.LinkedList;
import java.util.List;

public class LeftMostColumnWithOne {

    public static void main(String[] args) {
        BinaryMatrix binaryMatrix = new BinaryMatrix();
        System.out.println(leftMostColumnWithOne(binaryMatrix));
    }
    public static int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
//        List<Integer> dimension = binaryMatrix.dimensions();
        List<Integer> dimension = new LinkedList<>();
        int row = dimension.get(0);
        int col_f = dimension.get(1);
        int col = col_f;
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            list.add(i);
        }
        int col_min= 0;
        while(true){
            if (col == col_min){
                return col;
            }
            int mid = (col_min + col)/2;
            List<Integer> newList = new LinkedList<>();
            for (int cr : list) {
//                int ans = binaryMatrix.get(cr, mid);
                int ans = 1;
                if (ans == 1) {
                    newList.add(cr);
                }
            }

            if (newList.size() == 0){
                if (mid+1 == col_f)
                    return -1;
                col_min = mid+1;
            }else{
                col = mid;
                list = newList;
            }
        }
    }
}
