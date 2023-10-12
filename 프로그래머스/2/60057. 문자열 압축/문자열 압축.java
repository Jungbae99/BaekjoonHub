import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();
        int count = 1;

        for (int i = 1; i <= s.length() / 2; i++) {
            StringBuilder result = new StringBuilder();

            String base = s.substring(0, i); // abc
            for (int j = i; j <= s.length(); j += i) { // 3개씩 증가 (i부터 시작하는 이유는 앞 문자부터니까!)
                int endIdx = Math.min(j + i, s.length()); // endIndex 를 정한다 ( 3씩 증가하겠지? )
                String compare = s.substring(j, endIdx); // compare 는 계속 끊어서 비교되는 값들

                if (base.equals(compare)) {
                    count++;
                } else {
                    if (count >= 2) {
                        result.append(count);
                    }
                    result.append(base);
                    base = compare; // 자동으로 base 초기화
                    count = 1;
                }
            }
                result.append(base);
                answer = Math.min(answer, result.length());
        }
        return answer;
    }
}