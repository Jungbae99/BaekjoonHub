import java.util.*;


class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        col -= 1;
        row_begin -= 1;
        int finalCol = col;

        Arrays.sort(data, (o1, o2) ->{
            if (o1[finalCol] == o2[finalCol]) return o2[0] - o1[0];
            return o1[finalCol] - o2[finalCol];
        });

        for (int i = row_begin; i < row_end; i++) {
            int finAll = i + 1;
            int dataTotal = Arrays.stream(data[i])
                    .map(j -> j % finAll)
                    .sum();
            answer = (answer ^ dataTotal);
        }


        return answer;
    }
}