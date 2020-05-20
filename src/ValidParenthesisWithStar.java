import java.util.Stack;

public class ValidParenthesisWithStar {

    public boolean checkValidString(String s) {
        Stack<Integer> pStack = new Stack<>();
        Stack<Integer> sStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                pStack.push(i);
            }else if(s.charAt(i) == ')'){
                if (pStack.size() > 0){
                    pStack.pop();
                }else if(sStack.size() > 0){
                    sStack.pop();
                }else
                    return false;
            }else{
                sStack.push(i);
            }
        }
        while (pStack.size() > 0 && sStack.size()> 0){
            int p = pStack.pop();
            int star = sStack.pop();
            if (star < p ){
                return false;
            }
        }
        return pStack.size() == 0;
    }

}
