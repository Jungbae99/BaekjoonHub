import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = enemy.length;
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int army = n;
        int skill = k;
        for (int i = 0; i < enemy.length; i++) {
            army -= enemy[i];
            pq.add(enemy[i]);

            if (army < 0) {
                if (skill > 0 && !pq.isEmpty()) {
                    army += pq.poll();
                    skill--;
                } else {
                    answer = i;
                    break;
                }
            }
        }
        return answer;
    }
}