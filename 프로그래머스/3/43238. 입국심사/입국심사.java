import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long start = 0;
        long end = (long) n * (long)times[times.length - 1];
        long mid;
        
        
        while(start <= end) {
            long sum = 0;
            mid = (start + end) / 2; 
            
            for(int time: times){
                sum += mid / time; // 몫을 구하면 그 심사관이 몇명을 처리할 수 있는지 알 수 있다.
            }
            
            // 이제 심사관이 얼마만큼의 심사자들을 통과시켰는지 계산하자
            if(sum >= n) { // 만약 원하는 만큼의 심사자를 통과시켰다면? 시간을 줄여서 최소시간을 구하자
                answer = mid;
                end = mid - 1;
                
            } else { // 원하는 만큼 통과시키지 못했다면 시간을 늘려주자.
                start = mid + 1;
            }
        }
        
        
        return answer;
    }
}