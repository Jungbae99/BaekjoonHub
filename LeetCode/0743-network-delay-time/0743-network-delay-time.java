class Solution {
public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] time : times) {
            graph.computeIfAbsent(time[0], g -> new HashMap<>()).put(time[1], time[2]);
        }

        PriorityQueue<Map<String, Integer>> pq = new PriorityQueue<>((a, b) -> a.get("time").compareTo(b.get("time")));
        pq.add(Map.of("node", k, "time", 0));

        Map<Integer, Integer> dist = new HashMap<>();

        while (!pq.isEmpty()) {
            Map<String, Integer> cur = pq.poll();
            int arrive = cur.get("node");
            int time = cur.get("time");

            if (!dist.containsKey(arrive)) {
                dist.put(arrive, time);
                if (graph.containsKey(arrive)) {
                    for (Map.Entry<Integer, Integer> v : graph.get(arrive).entrySet()) {
                        int alt = time + v.getValue();
                        pq.add(Map.of("node", v.getKey(), "time", alt));
                    }
                }
            }
        }

        if (dist.size() == n) {
            return Collections.max(dist.values());
        }
        return -1;
    }
}