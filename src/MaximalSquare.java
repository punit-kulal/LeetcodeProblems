public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int[][] vSum, hSum, tSum;
        if (matrix.length == 0)
            return 0;
        int ans=0,rows = matrix.length;
        int col = matrix[0].length;
        vSum = new int[rows][col];
        hSum = new int[rows][col];
        tSum = new int[rows][col];
        for (int i = 0; i < col; i++) {
            vSum[0][i] = Character.getNumericValue(matrix[0][i]);
            tSum[0][i] = Character.getNumericValue(matrix[0][i]);
        }
        for (int i = 0; i < rows; i++) {
            hSum[i][0] = Character.getNumericValue(matrix[i][0]);
            tSum[i][0] = Character.getNumericValue(matrix[i][0]);
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1'){
                    vSum[i][j] = vSum[i-1][j] + 1;
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == '1'){
                    hSum[i][j] = hSum[i][j-1] + 1;
                }
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == '1'){
                    tSum[i][j] = Math.min(tSum[i-1][j-1],Math.min(vSum[i-1][j], hSum[i][j-1])) + 1;
                    ans = Math.max(ans, tSum[i][j]*tSum[i][j]);
                }
            }
        }
        return ans;
    }
}
