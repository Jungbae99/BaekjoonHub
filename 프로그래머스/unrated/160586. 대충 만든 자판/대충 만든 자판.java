import java.util.*;


class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        HashMap<Character, Integer> map = new HashMap<>();
        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                char c = key.charAt(i);
                if (!map.containsKey(c) || i < map.get(c)) {
                    map.put(c, i + 1);
                }
            }
        }
        int tmp = 0;
        for (int j = 0; j < targets.length; j++) {
            for (int i = 0; i < targets[j].length(); i++) {
                char c = targets[j].charAt(i);
                if (!map.containsKey(c)) {
                    tmp = 0;
                    break;
                } else {
                    tmp += map.get(c);
                }
            }
            answer[j] = tmp == 0 ? -1 : tmp;
            tmp= 0;
        }
        return answer;
    }
}