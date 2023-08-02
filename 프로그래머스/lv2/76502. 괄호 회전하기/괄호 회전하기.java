import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        char tmp = 'c';
        char[] charArray;
        
       for (int i = 0; i < s.length(); i++) {
            charArray = s.toCharArray();
            if (check(charArray)) {
                answer++;
            }
            tmp = s.charAt(0);
            s = s.substring(1) + tmp;
        }
        return answer;
    }
    
    public static boolean check(char[] c) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < c.length; i++) {
            char ch = c[i];
            if (ch == '(' || ch == '[' || ch == '{') { //여는거면 push
                stack.push(ch);
            } else { // 닫는거면 검증
                if (stack.isEmpty()) {
                    return false; // 닫을건데 비어있으면 false
                 }
                if (ch == ')' && stack.peek() == '(') {
                    stack.pop();
                }
                if (ch == '}' && stack.peek() == '{') {
                    stack.pop();
                }
                if (ch == ']' && stack.peek() == '[') {
                    stack.pop();
                }

            }
        }
        if (stack.isEmpty()) return true;
        else return false;
    }
    
    
    
}