import java.util.*;

class Solution {
    public long solution(int[] weights) {
       long answer = 0;
        Map<Double, Integer> map = new HashMap<>();
        Arrays.sort(weights);

        for (int weight : weights) {
            double a = weight * 1;
            double b = (weight * 1.0) / 2;
            double c = (weight * 2.0) / 3;
            double d = (weight * 3.0) / 4;

            if (map.containsKey(a)) answer += map.get(a);
            if (map.containsKey(b)) answer += map.get(b);
            if (map.containsKey(c)) answer += map.get(c);
            if (map.containsKey(d)) answer += map.get(d);

            map.put((double) weight, map.getOrDefault((double)weight, 0) + 1);
        }
        return answer;
    }
}