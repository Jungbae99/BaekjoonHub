import java.util.*;
class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {int[] answer = new int[queries.length];
        int answerIndex = 0;
        int[][] arr = new int[rows][columns];
        int[][] result = new int[rows][columns];

        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j] = result[i][j] = ++index;

            }
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < queries.length; i++) {
            int tmp = 0;
            for (int j = 0; j < queries[i].length; j++) {
                queries[i][j] -= 1;
            }
            int startX = queries[i][0];
            int startY = queries[i][1];
            int endX = queries[i][2];
            int endY = queries[i][3];
            tmp = arr[startX][startY];

            for (int j = startX; j < endX; j++) {
                arr[j][startY] = arr[j + 1][startY];
            }

            for (int j = startY; j < endY; j++) {
                arr[endX][j] = arr[endX][j + 1];
            }

            for (int j = endX; j > startX; j--) {
                arr[j][endY] = arr[j - 1][endY];
            }

            for (int j = endY; j > startY + 1; j--) {
                arr[startX][j] = arr[startX][j - 1];
            }
            arr[startX][startY + 1] = tmp;

            for (int j = 0; j < arr.length; j++) {
                for (int k = 0; k < arr[0].length; k++) {
                    if (arr[j][k] != result[j][k]) {
                        min = Math.min(arr[j][k], min);
                    }
                }
            }
            result = new int[rows][columns];
            for (int j = 0; j < rows; j++) {
                result[j] = Arrays.copyOf(arr[j], arr[j].length);
            }
            answer[answerIndex] = min;
            answerIndex++;
            min = Integer.MAX_VALUE;
        }

        return answer;

    }
}