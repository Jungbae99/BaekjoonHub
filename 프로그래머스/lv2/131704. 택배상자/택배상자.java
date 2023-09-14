import java.util.*;

class Solution {
    public int solution(int[] order) {
       int answer = 0;

        int op = 0; // 배열의 포인터
        // 컨테이너 벨트에서 현재 확인중인 박스 번호
        int currentBox = 1;
        Stack<Integer> assistanceBelt = new Stack<>();
        while (op < order.length) {
            if (order[op] > currentBox) {
                assistanceBelt.push(currentBox);
                currentBox++;
            } else if (order[op] == currentBox) {
                answer++;
                op++;
                currentBox++;
            } else {
                while (!assistanceBelt.isEmpty() && order[op] == assistanceBelt.peek()) {
                    assistanceBelt.pop();
                    answer++;
                    op++;
                }
                if (op >= order.length || order[op] < currentBox) break;
            }
        }
        return answer;
    }
}