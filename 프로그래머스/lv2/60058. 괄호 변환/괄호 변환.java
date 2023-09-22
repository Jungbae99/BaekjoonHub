import java.util.*;

class Solution {
     public static String solution(String p) {
        // 1. 입력이 빈 문자열인 경우, 빈 문자열 반환
        if (p.isEmpty()) {
            return "";
        }

        // 2. 문자열 p를 두 "균형잡힌 괄호 문자열" u, v로 분리
        int balance = 0;
        int index = 0;
        do {
            if (p.charAt(index) == '(') {
                balance++;
            } else {
                balance--;
            }
            index++;
        } while (balance != 0);

        String u = p.substring(0, index);
        String v = p.substring(index);

        // 3. u가 "올바른 괄호 문자열"인지 판단
        if (isCorrect(u)) {
            // 3-1. u가 "올바른 괄호 문자열"이면 v에 대해 재귀 호출 후 결과와 u를 이어 붙여 반환
            return u + solution(v);
        } else {
            // 4. u가 "올바른 괄호 문자열"이 아니라면 아래 과정 수행
            StringBuilder result = new StringBuilder();
            result.append("("); // 4-1
            result.append(solution(v)); // 4-2
            result.append(")"); // 4-3

            // u의 첫 번째와 마지막 문자 제거 및 괄호 방향 뒤집기
            for (int i = 1; i < u.length() - 1; i++) {
                char ch = u.charAt(i);
                if (ch == '(') {
                    result.append(")");
                } else {
                    result.append("(");
                }
            }

            return result.toString(); // 4-5
        }
     }
         
         private static boolean isCorrect(String str) {
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}