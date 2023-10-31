class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int tmp[][] = new int[triangle.length][triangle.length];

        tmp[0][0] = triangle[0][0];

        for (int i = 1; i < triangle.length; i++) {
            tmp[i][0] = tmp[i - 1][0] + triangle[i][0];
            tmp[i][i] = tmp[i - 1][i - 1] + triangle[i][i];

            for (int j = 1; j <= i - 1; j++) {
                tmp[i][j] = Math.max(tmp[i - 1][j - 1], tmp[i - 1][j]) + triangle[i][j];
                answer = Math.max(answer, tmp[i][j]);
            }
        }

        return answer;
    }
}