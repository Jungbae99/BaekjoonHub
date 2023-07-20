
import java.util.Stack;
class Solution {
    boolean solution(String s) {
        boolean answer = true;

        int chk = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') chk++;
            else chk--;
            
            if (chk < 0) return false;
        }

        if (chk != 0 || s.length() == 0) {
            answer = false;
        }
        
        return answer;
    }
}