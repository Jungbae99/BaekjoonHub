import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        
        // 참가자 명단 카운트
        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        
        // 완주자 명단 카운트 감소
        for (String c : completion) {
            map.put(c, map.get(c) - 1);
        }
        
        // 값이 0이 아닌 사람이 완주하지 못한 사람
        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                return key;
            }
        }
        
        return "";
    }
}