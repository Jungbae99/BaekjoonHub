import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
       Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum1 = 0;
        long sum2 = 0;
        for (int i = 0; i < queue1.length; i++) {
            q1.add(queue1[i]);
            sum1 += (long)queue1[i];
            q2.add(queue2[i]);
            sum2 += (long)queue2[i];
        }

        while (sum1 != sum2) {
            if (answer > (queue1.length + queue2.length) * 2) return -1;
            int val = 0;
            if (sum1 < sum2) {
                val = q2.poll();
                q1.add(val);
                sum1 += (long)val;
                sum2 -= (long)val;
            } else if (sum1 > sum2) {
                val = q1.poll();
                q2.add(val);
                sum2 += (long)val;
                sum1 -= (long)val;
            } else {
                return answer;
            }
            answer++;
        }
        return answer;
    }
}