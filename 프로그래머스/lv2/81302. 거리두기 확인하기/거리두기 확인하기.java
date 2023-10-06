import java.util.*;

class Solution {
   public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int i = 0; i < places.length; i++) {
            String[] room = places[i];
            boolean isSafe = true; // 거리두기가 지켜진 경우

            // 모든 자리를 순회하면서 거리두기 확인
            for (int row = 0; row < 5 && isSafe; row++) {
                for (int col = 0; col < 5 && isSafe; col++) {
                    if (room[row].charAt(col) == 'P') {
                        if (!isValid(row, col, room)) {
                            isSafe = false;
                        }
                    }
                }
            }

            answer[i] = isSafe ? 1 : 0;
        }

        return answer;
    }

    private static boolean isValid(int row, int col, String[] room) {
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{row, col});


        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            // position = { 2, 1 }
            for (int i = 0; i < 4; i++) {
                int newRow = position[0] + dr[i]; // 1, 3, 2, 2
                int newCol = position[1] + dc[i]; // 1, 1, 2, 0

                if (newRow < 0 || newCol < 0 || newRow >= 5 || newCol >= 5 || (newRow == row && newCol == col)) {
                    continue;
                }

                int distance = Math.abs(newRow - row) + Math.abs(newCol - col);

                if (room[newRow].charAt(newCol) == 'P' && distance <= 2) {
                    return false; // 거리체크 중요
                } else if (room[newRow].charAt(newCol) == 'O' && distance < 2) {
                    queue.offer(new int[]{newRow, newCol}); 
                }
            }
        }

        return true;
    }
}