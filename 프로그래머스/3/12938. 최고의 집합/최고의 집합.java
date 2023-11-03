import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int share = s / n;
        int remainder = s % n;
        
        if(share == 0) return new int[]{-1};
        
        int[] answer = new int[n];
        
        for(int i=0; i<answer.length; i++){
            answer[i] = share;
            if(remainder > 0){
               answer[i] += 1;
                remainder--;
            }
        }
        Arrays.sort(answer);
        return answer;
    }
}