import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        Arrays.sort(jobs, (o1, o2) -> {
            return o1[0] - o2[0];
        });
        
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        int pqIndex = 0;
        int end = 0;
        int count = 0;
        
        while( count < jobs.length ){
            
            while(pqIndex < jobs.length  && jobs[pqIndex][0] <= end ){
                pq.add(jobs[pqIndex++]);
            }
            
            if(pq.isEmpty()){
                end = jobs[pqIndex][0];
            } else {
                
                int[] tmp  = pq.poll();
                answer += tmp[1] - tmp[0] + end;
                end += tmp[1];
                count++;
            }
        }
            
            
        return answer / count;
    }
}