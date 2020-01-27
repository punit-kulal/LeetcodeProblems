
import java.util.*;

class PhoneNumber {
    static char[] charDigits;
    static Map<Character, char[]> numberMap;
    public List<String> letterCombinations(String digits) {
        charDigits = digits.toCharArray();
        numberMap = new HashMap<>();
        numberMap.put('2', "abc".toCharArray());
        numberMap.put('3', "def".toCharArray());
        numberMap.put('4', "ghi".toCharArray());
        numberMap.put('5', "jkl".toCharArray());
        numberMap.put('6', "mno".toCharArray());
        numberMap.put('7', "pqrs".toCharArray());
        numberMap.put('8', "tuv".toCharArray());
        numberMap.put('9', "wxyz".toCharArray());
        Set<String> set = new HashSet<>(recursion(0));
        return new ArrayList<>(set);

    }

    public List<String> recursion(int index){
        List<String> prev;
        List<String> result = new LinkedList<>();
        if (index >= charDigits.length)
            return result;
        char current = charDigits[index];
        if (index < charDigits.length-1){
            prev = recursion(index+1);
            for(String sequence: prev){
                String temp;
                for(char prefix: numberMap.get(current)){
                    temp = prefix + sequence;
                    result.add(temp);
                }
            }
        }else{
            for(char prefix: numberMap.get(current)){
                result.add(prefix + "");
            }
        }
        return result;
    }
}