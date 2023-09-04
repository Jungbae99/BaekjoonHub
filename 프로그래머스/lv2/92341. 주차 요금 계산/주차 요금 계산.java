import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        boolean[] check = new boolean[records.length];
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> map = new TreeMap<>();

        for (int i = 0; i < records.length; i++) {
            if (check[i] == true) continue;

            for (int j = i + 1; j < records.length; j++) {
                String[] split1 = records[i].split(" ");
                String[] split2 = records[j].split(" ");
                if (split1[1].equals(split2[1])) {
                    check[i] = true;
                    check[j] = true;
                    String[] minute1 = split1[0].split(":");
                    String[] minute2 = split2[0].split(":");
                    int intMinute1 = (Integer.parseInt(minute1[0]) * 60) + Integer.parseInt(minute1[1]);
                    int intMinute2 = (Integer.parseInt(minute2[0]) * 60) + Integer.parseInt(minute2[1]);
                    int minutes = (intMinute2 - intMinute1);
                    map.put(split1[1], map.getOrDefault(split1[1], 0) + minutes);
                    break;
                }
            }
        }

        for (int i = 0; i < records.length; i++) {
            if (!check[i]) {
                String[] split = records[i].split(" ");
                String[] minute = split[0].split(":");
                int twelveMinutes = 24 * 60 - 1;
                int minutes = twelveMinutes - (Integer.parseInt(minute[0]) * 60 + Integer.parseInt(minute[1]));
                map.put(split[1], map.getOrDefault(split[1], 0) + minutes);
            }
        }

        for (Integer value : map.values()) {
            if (value <= fees[0]) {
                result.add(fees[1]);
            } else {
                value -= fees[0];
                int ceilResult = 0;
                if (value % fees[2] == 0) {
                    ceilResult = value / fees[2];
                } else {
                    ceilResult = value / fees[2] + 1;
                }
                result.add((int) (fees[1] + ceilResult * fees[3]));
            }
        }
        int[] answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}