import java.util.Arrays;
import java.util.List;

public class LC214 {
    public String shortestPalindrome(String s) {
        char[] chars = s.toCharArray();
        char[] rchars = new char[chars.length];
        int pIndex = -1;
        for (int i = 0; i < chars.length; i++) {
            rchars[i] = chars[chars.length-1-i];
        }
        for (int i = chars.length-1; i >= 0; i++) {
            if (isPalindrome(i,chars)){
                pIndex = i;
                break;
            }
        }
        if (s.length() == 0){
            return s;
        }else{
            return new String(rchars).substring(0, s.length()-pIndex-1) + s;
        }


    }

    private boolean isPalindrome(int i, char[] chars){
        for (int j = 0; j <= i; j++) {
            if (chars[j] != chars[i-j]){
                return false;
            }
        }
        return true;
    }
}