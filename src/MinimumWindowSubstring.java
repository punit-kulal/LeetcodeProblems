import java.util.HashMap;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        int aStartIndex = 0, aEndIndex = 0;
        if (t.length() == 0 || s.length() == 0)
            return "";

        HashMap<Character, Integer> targetCounter = new HashMap<>();
        count(t, targetCounter);
        int size = 0;
        int startIndex = 0, endIndex = 0;
        HashMap<Character, Integer> sCounter = new HashMap<>();
        char[] chars = s.toCharArray();
        while (endIndex < s.length()) {
            putCounter(chars[endIndex], sCounter);
            if (check(sCounter, targetCounter)) {
                size = endIndex - startIndex + 1;
                aStartIndex = startIndex;
                aEndIndex = endIndex;
                break;
            }
            endIndex++;
        }

        if (endIndex == s.length()) {
            return "";
        }

        while (true) {
            while (check(sCounter, targetCounter) || startIndex < endIndex - size) {
                if (endIndex - startIndex + 1 < size || check(sCounter, targetCounter)) {
                    aEndIndex = endIndex;
                    aStartIndex = startIndex;
                    size = endIndex - startIndex + 1;
                }
                removeCounter(chars[startIndex], sCounter);
                startIndex++;
            }

            if (endIndex == s.length() - 1)
                break;

            putCounter(chars[++endIndex], sCounter);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = aStartIndex; i <= aEndIndex; i++) {
            sb.append(chars[i]);
        }
        return sb.toString();

    }

    private void count(String a, HashMap<Character, Integer> counter) {
        char[] chars = a.toCharArray();
        for (Character c : chars) {
            putCounter(c, counter);
        }
    }

    private boolean check(HashMap<Character, Integer> source, HashMap<Character, Integer> target) {
        for (Character c : target.keySet()) {
            if (!source.containsKey(c) || (target.get(c) > source.get(c))) {
                return false;
            }
        }

        return true;
    }

    private void putCounter(Character c, HashMap<Character, Integer> counter) {
        if (counter.containsKey(c)) {
            Integer x = counter.get(c);
            counter.put(c, ++x);
        } else {
            counter.put(c, 1);
        }
    }

    private void removeCounter(Character c, HashMap<Character, Integer> counter) {
        if (counter.containsKey(c)) {
            Integer x = counter.get(c);
            if (x == 1)
                counter.remove(c);
            else
                counter.put(c, --x);
        } else {
            throw new IllegalStateException();
        }
    }


}
