import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>, List<String>> anagramMap = new HashMap<>();
        for (String str: strs) {
            HashMap<Character, Integer> counter = new HashMap<>();
            char[] chars = str.toCharArray();
            for (char character :chars) {
                if (counter.containsKey(character)){
                    int count = counter.get(character);
                    counter.put(character, ++count);
                }else{
                    counter.put(character, 1);
                }
            }
            if (anagramMap.containsKey(counter)){
                anagramMap.get(counter).add(str);
            }else {
                List<String> l = new LinkedList<>();
                l.add(str);
                anagramMap.put(counter, l);
            }
        }
        return new LinkedList<>(anagramMap.values());
    }
}
