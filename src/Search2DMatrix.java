public class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0 ){
            return  false;
        }
        int m = matrix.length;
        int n = matrix[0].length;

        if (matrix[0][0] > target || matrix[m-1][n-1] < target){
            return  false;
        }
        int row = columnBinarySearch(matrix, target, 0, m);

        if (matrix[row][0] == target)
            return true;

        return rowBinarySearch(matrix, row, target, 0, n-1);



    }

    private int columnBinarySearch(int[][] matrix, int target,int start, int end){
        if (start + 1 == end){
            return start;
        }
        int mid = (start+ end +1)/2;

        if (target < matrix[mid][0]){
            return columnBinarySearch(matrix, target, start, mid);
        }else{
            return columnBinarySearch(matrix, target, mid, end);
        }
    }

    private boolean rowBinarySearch(int[][] matrix, int row, int target, int start, int end){
        if (start > end){
            return false;
        }

        int mid = (start+end+1)/2;
        if (target == matrix[row][mid]){
            return true;
        }else if (target > matrix[row][mid]){
            return rowBinarySearch(matrix, row, target, mid+1, end);
        }else {
            return rowBinarySearch(matrix, row, target, start, mid-1);
        }
    }

}
