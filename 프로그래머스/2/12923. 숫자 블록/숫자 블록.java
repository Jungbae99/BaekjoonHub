import java.util.*;

class Solution {
    
     public int[] solution(long begin, long end) {

        int[] answer = new int[(int) (end - begin) + 1];

        for(int i = 0; i<answer.length; i++){
            long num = begin + i;
            
            int max_divisor = 1;
            for(int div = 2; div <= Math.sqrt(num); div++){
                if(num % div==0){
                    int divisor1 = (int) div;
                    int divisor2 = (int) (num / div);
                    
                    max_divisor = Math.max(max_divisor, divisor1);
                    
                    if(divisor2 <= 10000000){
                        max_divisor = Math.max(max_divisor, divisor2);
                    }
                }
            }
            answer[i] = max_divisor;
        }
         if(begin == 1){
             answer[0] = 0;
         }
         return answer;
    }
}