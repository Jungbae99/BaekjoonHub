class Solution {
public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);
        List<int[]> answer = new ArrayList<>();

        for (int i = people.length - 1; i >= 0; i--) {
            answer.add(people[i][1], people[i]);
        }

        return answer.toArray(new int[answer.size()][2]);
    }
}