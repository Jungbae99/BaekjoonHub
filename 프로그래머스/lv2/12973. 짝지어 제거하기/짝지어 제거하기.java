import java.util.*;

class Solution
{
    public int solution(String str)
    {
        
        
        String[] split = str.split("");
        Stack<String> stack = new Stack<>();

        for (String s : split) {
            if (!stack.isEmpty() && stack.peek().equals(s)) {
                stack.pop();
            } else {
                stack.push(s);
            }
        }
        


        return stack.isEmpty() ? 1 : 0;

    }
}