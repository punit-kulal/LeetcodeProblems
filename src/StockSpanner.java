import java.util.*;

class StockSpanner {

    Stack<Map.Entry<Integer, Integer>> internalStack;
    int currentIndex;
    public StockSpanner() {
        internalStack = new Stack<>();
        currentIndex = 0;
    }

    public int next(int price) {
        while(internalStack.size() > 0 && internalStack.peek().getKey() <= price){
            internalStack.pop();
        }
        int count = 1;
        if (internalStack.size() == 0){
            count = currentIndex+count;
        }else{
            int index = internalStack.peek().getValue();
            count += currentIndex-index;
        }
        currentIndex++;
        internalStack.push(new AbstractMap.SimpleEntry<>(price, currentIndex));
        return count;
    }
}