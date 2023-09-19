import java.util.*;

class Solution {
    public String solution(int n) {
        StringBuilder answer= new StringBuilder("");
        
        
        //1,2,4
        int tmp = 0;
        
        while(n != 0){
            tmp = n % 3;
            n /= 3;
            
            if(tmp == 0){
                tmp = 4;
                n -= 1;
            }
            answer.append(tmp);
        }
        
        
        
        return answer.reverse().toString();
    }
}