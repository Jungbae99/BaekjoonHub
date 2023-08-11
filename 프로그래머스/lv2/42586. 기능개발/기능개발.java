import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();

        int count = 0;

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            queue.add(progresses[i]);
        }

        int progressIndex = 0;
        while (!queue.isEmpty()) {

            for (int j = 0; j < progresses.length; j++) {
                progresses[j] += speeds[j];
            }
            if (progresses[progressIndex] >= 100) {
                int cnt = 0;
                for (int i = progressIndex; i < progresses.length; i++) {
                    if (progresses[i] >= 100) {
                        queue.poll();
                        cnt++;
                    } else {
                        progressIndex = i;
                        break;
                    }
                }
                result.add(cnt);
            }
        }
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}