import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) +1 );
        }
        //map 에 이제 부위별로 숫자가 등록되었어

        int answer = 1;
        for (Integer value : map.values()) {
            answer *= (value + 1);
        }
        
        return answer -1;
    }
}