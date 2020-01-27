import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        List<Set<Character>> vertical = new ArrayList<>(9);
        List<Set<Character>> horizontal = new ArrayList<>(9);
        Set<Character>[][] square = new Set[3][3];

        for (int t = 0; t < 9; t++){
            vertical.set(t, new HashSet<>());
            horizontal.set(t, new HashSet<>());
        }

        for (int x =0; x < 3; x++){
            for(int y = 0; y < 3; y++){
                square[x][y] = new HashSet<>();
            }
        }

        for (int i = 0; i<9;i++){
            for (int j = 0; j < 9; j++){
                char current = board[i][j];
                if (current != '.')
                    continue;

                if (vertical.get(i).contains(current))
                    return false;
                else
                    vertical.get(i).add(current);

                if (horizontal.get(i).contains(current))
                    return false;
                else
                    horizontal.get(i).add(current);

                if (square[i/3][j/3].contains(current))
                    return false;
                else
                    square[i/3][j/3].add(current);
            }
        }
        return true;
    }
}
