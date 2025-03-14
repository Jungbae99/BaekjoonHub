class Solution {
public static int[][] reconstructQueue(int[][] people) {

        Queue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[0] != b[0] ? b[0] - a[0] : a[1] - b[1]
        );

        for (int[] person : people) {
            pq.add(person);
        }

        List<int[]> result = new ArrayList<>();

        while (!pq.isEmpty()) {
            int[] person = pq.poll();

            result.add(person[1], person);
        }

        return result.toArray(new int[result.size()][2]);
    }
}