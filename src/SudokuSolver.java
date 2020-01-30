import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SudokuSolver {

    public static void main(String[] args){
        new CombinationSum().combinationSum(new int[1], 7);
    }
    public void solveSudoku(char[][] board) {
        board = new char[][]{{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        List<Set<Character>> vertical = new ArrayList<>(9);
        List<Set<Character>> horizontal = new ArrayList<>(9);
        Set<Character>[][] square = new Set[3][3];

        for (int t = 0; t < 9; t++) {
            vertical.add(new HashSet<>());
            horizontal.add(new HashSet<>());
        }

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                square[x][y] = new HashSet<>();
            }
        }
        for (int i = 0; i < 9; i++){
            for (int j = 0; j< 9; j++){
                if (board[i][j] != '.') {
                    horizontal.get(i).add(board[i][j]);
                    vertical.get(j).add(board[i][j]);
                    square[i/3][j/3].add(board[i][j]);
                }
            }
        }
        int[] m = getNewDot(0, 0, board);
        recursion(board, vertical, horizontal, square, m[0], m[1]);
    }

    private boolean recursion(char[][] board, List<Set<Character>> vertical, List<Set<Character>> horizontal,
                              Set<Character>[][] square, int i, int j) {
        if (i == 9 && j == 9){
            return true;
        }
        boolean answer = false;
        for (int a = 1; a <= 9; a++) {
            char n = Character.forDigit(a, 10);
            if (!horizontal.get(i).contains(n) && !vertical.get(j).contains(n) && !square[i / 3][j / 3].contains(n)) {
                board[i][j] = n;
                horizontal.get(i).add(n);
                vertical.get(j).add(n);
                square[i / 3][j / 3].add(n);
                int[] newDot = getNewDot(i, j, board);
                answer = recursion(board, vertical, horizontal, square, newDot[0], newDot[1]);
                if (!answer) {
                    horizontal.get(i).remove(n);
                    vertical.get(j).remove(n);
                    square[i / 3][j / 3].remove(n);
                    board[i][j] = '.';
                } else {
                    return true;
                }

            }
        }
        return false;
    }

    private int[] getNewDot(int i, int j, char[][] board) {
        while (i < 9) {
            while (j < 9) {
                if (board[i][j] == '.'){
                    return new int[]{i, j};
                }
                j++;
            }
            j = 0;
            i++;
        }

        return new int[]{9,9};
    }

}
