import java.util.*;


class Solution {
    public int[] solution(int N, int[] stages) {
        int[] Narr = new int[N];
        for (int i = 0; i < N; i++) {
            Narr[i] = i + 1;
        }

        
        int n = stages.length; // 중간값 계산용
        Arrays.sort(stages);

        List<Double> rate = new ArrayList<>(); // 실패율
        List<Double> list = new ArrayList<>();
        Map<Integer, Double> map = new HashMap<>();

        for (int i = 0; i < Narr.length; i++) {
            Double count = (double) 0;

            for (int j = 0; j < stages.length; j++) {
                if (Narr[i] == stages[j]) count++;
            }
            Double failRate = count / n;

            if (count == 0) map.put(i, (double) 0);
            else map.put(i, failRate);
            n -= count;
        }

        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            double max = -1;
            int rKey = 0;
            for (int key : map.keySet()){
                if(max < map.get(key)){
                    max = map.get(key);
                    rKey = key;
                }
            }
            answer[i] = rKey+1;
            map.remove(rKey);
        }
        return answer;
    }
}