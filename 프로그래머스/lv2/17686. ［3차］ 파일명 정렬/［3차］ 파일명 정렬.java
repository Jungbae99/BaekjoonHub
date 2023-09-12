import java.util.*;

class Solution {
    public String[] solution(String[] files) {
       String[] answer = new String[files.length];
        String[][] answer2 = new String[files.length][3];

        for (int i = 0; i < files.length; i++) {
            int startIndex = -1;
            int endIndex = -1;
            int size = 0;
            boolean first = true;
            String s = files[i];
            for (int j = 0; j < files[i].length(); j++) {
                if (Character.isDigit(s.charAt(j))) {
                    if (first) {
                        first = false;
                        startIndex = j;
                    }
                    size++;
                } else {
                    if (!first) break;
                }
            }
                endIndex = startIndex + size - 1;

                answer2[i][0] = s.substring(0, startIndex);
                answer2[i][1] = s.substring(startIndex, endIndex + 1);
                answer2[i][2] = s.substring(endIndex + 1);
            }

            Arrays.sort(answer2, (o1, o2) -> {
                if (o1[0].toLowerCase().compareTo(o2[0].toLowerCase(Locale.ROOT)) > 0) {
                    return 1;
                } else if (o1[0].toLowerCase().compareTo(o2[0].toLowerCase(Locale.ROOT)) < 0) {
                    return -1;
                } else {
                    if (Integer.parseInt(o1[1]) > Integer.parseInt(o2[1])) {
                        return 1;
                    } else if (Integer.parseInt(o1[1]) < Integer.parseInt(o2[1])) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            });

        for (int i = 0; i < answer.length; i++) {
            answer[i] = answer2[i][0] + answer2[i][1] + answer2[i][2];
        }

        return answer;
    }
}