import java.util.*;

class Solution {
     public int solution(int N, int number) {
               List<Set<Integer>> list = new ArrayList<>();
        for(int i = 0; i <= 8; i++) {
            list.add(new HashSet<>());
        }
        
        list.get(1).add(N);
        
        // 중요: N 한 번 사용해서 number를 만들 수 있는지 체크
        if(N == number) return 1;
        
        for(int i = 2; i <= 8; i++){
            // 연속된 숫자 만들기 (NN, NNN, NNNN...)
            String repeat = "";
            for (int k = 0; k < i; k++){
                repeat += N;
            }
            list.get(i).add(Integer.parseInt(repeat));
            
            // 사칙연산으로 새로운 수 만들기
            for(int j = 1; j < i; j++) {
                for(int num1 : list.get(j)) {
                    for(int num2 : list.get(i - j)) {
                        // 덧셈
                        list.get(i).add(num1 + num2);
                        // 뺄셈 (두 방향 모두)
                        list.get(i).add(num1 - num2);
                        // 곱셈
                        list.get(i).add(num1 * num2);
                        // 나눗셈 (0으로 나누지 않을 때만)
                        if(num2 != 0) {
                            list.get(i).add(num1 / num2);
                        }
                    }
                }
            }
            
            // 목표 숫자를 찾았는지 확인
            if(list.get(i).contains(number)) {
                return i;
            }
        }
        
        return -1;
    }
}