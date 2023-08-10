import java.util.*;
class Solution {
    public int[] solution(String s) {
        String[] split = s.split("},\\{");

        split[0] = split[0].substring(2);
        split[split.length-1] = split[split.length-1].replaceAll("}", "");
        
        Arrays.sort(split, (String s1, String s2) -> s1.length() - s2.length());

        List<String> list = new ArrayList<>();
        list.add(split[0]);

        for (int i = 1; i < split.length; i++) {
            String[] split1 = split[i].split(",");
            for (int j = 0; j < split1.length; j++) {
                if(!list.contains(split1[j])){
                    list.add(split1[j]);
                }
            }
        }

        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = Integer.parseInt(list.get(i));
        }
        
        return answer;
    }
}