import java.util.LinkedList;

class Zigzag {
    public String convert(String s, int numRows) {
        LinkedList<Character>[] myList = new LinkedList[numRows];
        for (int i = 0; i < numRows; i++){
            myList[i] = new LinkedList<>();
        }

        char[] charArray = s.toCharArray();
        int indexer = 1;
        int index = 0;
        for(int i = 0; i < charArray.length; i++){
            myList[index].add(charArray[i]);
            if(index != 0 && index%(numRows-1) == 0){
                indexer *= -1;
            }
            index += indexer;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < numRows; i++){
            for(Character c: myList[i]){
                builder.append(c);
            }
        }
        return builder.toString();
    }
}