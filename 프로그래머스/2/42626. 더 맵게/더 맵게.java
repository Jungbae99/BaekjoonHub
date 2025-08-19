import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        for(int i= 0; i< scoville.length; i++){
            pq.add(scoville[i]);
        }
        
        int answer = 0;

        while (!pq.isEmpty()) {
            Integer now = pq.poll();
            if(now < K) {
                if (pq.isEmpty()) return -1;
                Integer next = pq.poll();
                pq.add(now + (next * 2));
                answer++;                
            }
        }
        return answer;
    }
}