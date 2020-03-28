import java.util.LinkedList;
import java.util.List;

public class JustifyWords {

    public List<String> fullJustify(String[] words, int maxWidth) {
        int i = 0;
        List<String> answer = new LinkedList<>();
        while (i<words.length){
            LinkedList<String> batch = new LinkedList<>();
            int stringLength = 0;
            while (i < words.length && stringLength+ batch.size()+words[i].length() <= maxWidth){
                batch.add(words[i]);
                stringLength += words[i].length();
                i++;
            }
            StringBuilder stringBuilder = new StringBuilder();
            if (i == words.length || batch.size() == 1){
                stringBuilder.append(batch.get(0));
                for (int j = 1; j < batch.size(); j++){
                    stringBuilder.append(" ");
                    stringBuilder.append(batch.get(j));
                }
                int blankSpace = maxWidth - stringBuilder.length();
                while (blankSpace > 0){
                    stringBuilder.append(" ");
                    blankSpace--;
                }
            }else{
                int totalBlankSpaceLength = (maxWidth-stringLength);
                int averageSpaceSize =totalBlankSpaceLength/(batch.size()-1);
                int extraSpaceCount = totalBlankSpaceLength - averageSpaceSize*(batch.size() -1);
                stringBuilder.append(batch.get(0));
                for (int x = 1; x < batch.size(); x++) {
                    for (int j = 0; j < averageSpaceSize; j++) {
                        stringBuilder.append(" ");
                    }
                    if (extraSpaceCount > 0){
                        stringBuilder.append(" ");
                        extraSpaceCount--;
                    }
                    stringBuilder.append(batch.get(x));
                }
            }
            answer.add(stringBuilder.toString());
        }
        return answer;
    }
}
