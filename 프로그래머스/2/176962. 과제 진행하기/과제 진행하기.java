import java.util.*;

class Solution {
    
      static class Task {
        private String name;
        private int start;
        private int playTime;

        public Task(String name, int start, int playTime) {
            this.name = name;
            this.start = start;
            this.playTime = playTime;
        }

        public Task(String name, int t) {
            this.name = name;
            this.playTime = t;
        }
    }
    
    public String[] solution(String[][] plans) {
        List<String> result = new ArrayList<>();
        PriorityQueue<Task> pq = new PriorityQueue<>((o1, o2) -> (o1.start - o2.start));

        for (int i = 0; i < plans.length; i++) {
            String[] split = plans[i][1].split(":");
            int minutes = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
            plans[i][1] = String.valueOf(minutes);
            pq.add(new Task(plans[i][0], minutes, Integer.parseInt(plans[i][2])));
        }

        Stack<Task> remain = new Stack<>();

        while (!pq.isEmpty()) {
            Task current = pq.poll();

            String curName = current.name;
            int curStart = current.start;
            int curPlayTime = current.playTime;

            int currentTime = curStart;

            if (!pq.isEmpty()) {
                Task nextTast = pq.peek();

                if (currentTime + curPlayTime < nextTast.start) { // 시간이 남으면?
                    result.add(curName);
                    currentTime += curPlayTime;

                    while (!remain.isEmpty()) {
                        Task rem = remain.pop();

                        if (currentTime + rem.playTime <= nextTast.start) { // 새로운 과제 시작 전까지 다 끝낼수있으면?
                            currentTime += rem.playTime;
                            result.add(rem.name);
                            continue;
                        } else {
                            int t = rem.playTime - (nextTast.start - currentTime);
                            remain.push(new Task(rem.name, t));
                            break;
                        }
                    }
                    // 다음 과제 시작이 딱 되면?
                } else if (curStart + curPlayTime == nextTast.start) {
                    result.add(curName);
                    continue;
                    // 지금 과제를 못 끝내면?
                } else {
                    int t = nextTast.start - currentTime;
                    remain.push(new Task(curName, curPlayTime - t));
                }
                // 더 남은 과제가 없을때? (큐)
            } else {

                // 더 남아있는 과제도 없을때? (스택)
                if (remain.isEmpty()) {
                    result.add(curName);
                } else {
                    result.add(curName);
                    while (!remain.isEmpty()) {
                        Task rem = remain.pop();
                        result.add(rem.name);
                    }
                }
            }
        }

        String[] answer = new String[result.size()];
        int i = 0;
        for (String s : result) {
            answer[i++] = s;
        }

        return answer;
    }
}