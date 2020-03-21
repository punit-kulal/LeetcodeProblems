import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TotalNQueens {

    public int totalNQueens(int n) {
        List<List<Integer>> queenLocation = new LinkedList<>();
        List<List<String>> solution = new LinkedList<>();
        placeQueen(queenLocation, solution, n);
        return solution.size();
    }

    private void placeQueen(List<List<Integer>> queenLocation, List<List<String>> solution, int totalQueens) {
        if (queenLocation.size() == totalQueens){
            addToSolution(queenLocation, solution);
            return;
        }
        int i = queenLocation.size();
        for(int j = 0; j < totalQueens; j++){
            if (isSafe(queenLocation, i, j)){
                queenLocation.add(Arrays.asList(i,j));
                placeQueen(queenLocation, solution, totalQueens);
                queenLocation.remove(queenLocation.size() - 1);
            }
        }
    }

    private void addToSolution(List<List<Integer>> queenLocations, List<List<String>> solution) {
        List<String> newSolution = new LinkedList<>();
        for (List<Integer> queenLocation : queenLocations) {
            int j = queenLocation.get(1);
            StringBuilder s = new StringBuilder();
            for (int z = 0; z < queenLocations.size(); z++){
                if (z==j){
                    s.append("Q");
                }else {
                    s.append(".");
                }
            }
            newSolution.add(s.toString());
        }
        solution.add(newSolution);
    }

    private boolean isSafe(List<List<Integer>> queenLocations, int i, int j) {
        for (List<Integer> queenLocation: queenLocations) {
            int i1 = queenLocation.get(0);
            int j1 = queenLocation.get(1);
            if (i == i1  || j == j1 || Math.abs(i - i1) == Math.abs(j- j1)) {
                return false;
            }
        }
        return true;
    }

}
