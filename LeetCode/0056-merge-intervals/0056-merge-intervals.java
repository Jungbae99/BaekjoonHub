
public class Solution {


    public int[][] merge(int[][] intervals) {

        List<int[]> answer = new ArrayList<>();

        // 첫번째 값을 기준으로 asc
        Arrays.sort(intervals, Comparator.comparing(a -> a[0]));

        for (int[] ints : intervals) {
            if (answer.isEmpty()) {
                answer.add(ints);
                continue;
            }

            if (answer.get(answer.size() - 1)[1] >= ints[0]) {
                int[] get = answer.get(answer.size() - 1);
                get[1] = Math.max(get[1], ints[1]);
            } else {
                answer.add(ints);
            }
        }

        return answer.toArray(new int[answer.size()][]);
    }



}
