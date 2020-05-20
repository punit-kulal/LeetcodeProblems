import java.util.*;

public class LC212 {
    public List<String> findWords(char[][] board, String[] words) {
        Map<Character, List<String>> map = new HashMap<>();
        Map<String, Map<Integer, Set<Map.Entry<Integer, Integer>>>> dp = new HashMap<>();
        List<String> answer = new LinkedList<>();
        for (String word : words) {
            if (word.length() > 0) {
                map.computeIfAbsent(word.charAt(0), k -> new LinkedList<>()).add(word);
            } else {
                answer.add(word);
            }
        }

        if (board.length == 0) {
            return answer;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (map.containsKey(board[i][j]))
                    search(i, j, answer, map.get(board[i][j]), board, dp);
            }
        }
        return answer;
    }

    private void search(int i, int j, List<String> answer,  List<String>  wordsToFind, char[][] board, Map<String, Map<Integer, Set<Map.Entry<Integer, Integer>>>> dp) {
        Iterator<String> iterator = wordsToFind.iterator();
        while (iterator.hasNext()) {
            String word = iterator.next();
            Set<Map.Entry<Integer, Integer>> recursionSet = new HashSet<>();
            if (dfs(i, j, recursionSet, board, word, 0, dp)){
                answer.add(word);
                iterator.remove();
            }
        }
    }

    private boolean dfs(int i, int j, Set<Map.Entry<Integer, Integer>> recursionSet, char[][] board, String word, int i1, Map<String, Map<Integer, Set<Map.Entry<Integer, Integer>>>> dp) {
        if (i < 0 || j < 0 || i >= board.length || j >= board.length || recursionSet.contains(new AbstractMap.SimpleEntry<>(i,j))){
            return false;
        }
        if (dp.containsKey(word)){
            Map<Integer, Set<Map.Entry<Integer, Integer>>> wordDp = dp.get(word);
            if (wordDp.containsKey(i1)){
                Set<Map.Entry<Integer, Integer>> wordDpForI = wordDp.get(i1);
                if (wordDpForI.contains(new AbstractMap.SimpleEntry<>(i, j))){
                    return false;
                }
            }
        }
        if (board[i][j] == word.charAt(i1)){
            boolean ans = false;
            if (i1 == word.length()-1){
                ans = true;
            }
            recursionSet.add(new AbstractMap.SimpleEntry<>(i, j));
            ans = ans  || dfs(i, j+1, recursionSet, board, word, i1+1, dp) ||
            dfs(i, j-1, recursionSet, board, word, i1+1, dp) ||
            dfs(i+1, j, recursionSet, board, word, i1+1, dp) ||
            dfs(i-1, j, recursionSet, board, word, i1+1, dp);
            recursionSet.remove(new AbstractMap.SimpleEntry<>(i, j));
            if (!ans){
                if (!dp.containsKey(word)){
                    dp.put(word, new HashMap<>());
                }
                Map<Integer, Set<Map.Entry<Integer, Integer>>> wordDp = dp.get(word);
                if (!wordDp.containsKey(i1)){
                    wordDp.put(i1, new HashSet<>());
                }
                Set<Map.Entry<Integer, Integer>> wordDpForI = wordDp.get(i1);
                wordDpForI.add(new AbstractMap.SimpleEntry<>(i, j));
            }
            return  ans;
        }
        return false;
    }

}
