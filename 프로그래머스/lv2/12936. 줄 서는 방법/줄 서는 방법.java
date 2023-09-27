import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> list = new ArrayList<>();
        
        long f = 1;
        for(int i=1; i<=n; i++){
            list.add(i);
            f *= i;
        }
        k--;
        
        int index = 0;
        
        while(index < n){
            
            f /= n - index;
            answer[index++] = list.remove((int)(k / f));
            k %= f;
            
            
        }
        
        return answer;
    }
}