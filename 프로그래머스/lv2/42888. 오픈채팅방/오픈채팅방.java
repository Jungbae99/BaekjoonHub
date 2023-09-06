import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        List<String> result = new ArrayList<>();

        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < record.length; i++) {
            String[] split = record[i].split(" ");
            if (split[0].equals("Enter")) {
                map.put(split[1], split[2]);
            } else if (split[0].equals("Change")){
                map.replace(split[1], split[2]);
            }
        }

        for (int i = 0; i < record.length; i++) {
            String[] split = record[i].split(" ");
            if (split[0].equals("Enter")) {
                result.add(map.get(split[1]) + "님이 들어왔습니다.");
            } else if (split[0].equals("Leave")) {
                result.add(map.get(split[1]) + "님이 나갔습니다.");

            }
        }
        return result.toArray(new String[result.size()]);
    }
}