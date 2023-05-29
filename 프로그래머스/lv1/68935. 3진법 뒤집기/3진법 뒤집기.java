
import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n) throws IOException {
        Stack<Integer> stack = new Stack<>();
        int tmp = n;
        
        
        while (tmp != 0) {
            stack.push(tmp % 3);
            tmp /= 3;
        }
        int count = 1;
        int answer = 0;
        while(!stack.empty()){
            answer += stack.pop()*count;
            count *= 3;
        }
        
        return answer;
    }
}