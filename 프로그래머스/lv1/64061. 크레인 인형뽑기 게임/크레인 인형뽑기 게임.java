import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < moves.length; i++) {
            int j = moves[i];
            for (int k = 0; k < board.length; k++) {
                if (board[k][j-1]==0) continue;
                if (stack.isEmpty()) {
                    stack.push(board[k][j-1]);
                    board[k][j-1] = 0;
                    break;
                }
                else if (stack.peek().equals(board[k][j-1])) {
                    answer +=2 ;
                    board[k][j-1] = 0;
                    stack.pop();
                    break;
                }
                else if (board[k][j-1] != 0) {
                    stack.push(board[k][j-1]);
                    board[k][j-1] = 0;
                    break;
                }
            }

        }
        return answer;
    }
}