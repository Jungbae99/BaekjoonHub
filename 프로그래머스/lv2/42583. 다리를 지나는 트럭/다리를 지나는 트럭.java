import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
       int answer = 0;

        Queue<Integer> bridge = new LinkedList<>();
        int currentWeight = 0;
        int idx = 0;

        while (idx < truck_weights.length) {
            if (bridge.size() == bridge_length) { 
                currentWeight -= bridge.poll();
            }

            if (currentWeight + truck_weights[idx] <= weight) { 
                bridge.offer(truck_weights[idx]);
                currentWeight += truck_weights[idx];
                idx++;
            } else { 
                bridge.offer(0);
            }

            answer++; 
        }

        answer += bridge_length;

        return answer;
    }
}