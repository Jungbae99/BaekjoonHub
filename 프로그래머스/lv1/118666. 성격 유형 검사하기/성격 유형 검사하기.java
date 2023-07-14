import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";

        Map<Character, Integer> map = new HashMap<>();

       for (int i = 0; i < survey.length; i++) {
            if (choices[i] > 4) {
                map.put(survey[i].charAt(1), map.getOrDefault(survey[i].charAt(1), 0) + choices[i] - 4);
                map.put(survey[i].charAt(0), map.getOrDefault(survey[i].charAt(0), 0 )+ 0);
            }
            if (choices[i] < 4) {
                map.put(survey[i].charAt(0), map.getOrDefault(survey[i].charAt(0), 0) + 4- choices[i]);
                map.put(survey[i].charAt(1), map.getOrDefault(survey[i].charAt(1), 0 )+ 0);
            }
            if (choices[i] == 4) {
                map.put(survey[i].charAt(0), map.getOrDefault(survey[i].charAt(0), 0 )+ 0);
                map.put(survey[i].charAt(1), map.getOrDefault(survey[i].charAt(1), 0 )+ 0);
            }
        }


        if (map.containsKey('R')) {
            if (map.get('R') > map.get('T')) {
                answer += "R";
            } else if (map.get('R') < map.get('T')) {
                answer += "T";
            } else {
                answer += "R";
            }
        } else {
            answer += "R";
        }



        if (map.containsKey('C')) {
            if (map.get('C') > map.get('F')) {
                answer += "C";
            } else if (map.get('C') < map.get('F')) {
                answer += "F";
            } else {
                answer += "C";
            }
        }else {
            answer += "C";
        }


        if (map.containsKey('J')) {
            if (map.get('J') > map.get('M')) {
                answer += "J";
            } else if (map.get('J') < map.get('M')) {
                answer += "M";
            } else {
                answer += "J";
            }

        }else {
            answer += "J";
        }



        if (map.containsKey('A')) {
            if (map.get('A') > map.get('N')) {
                answer += "A";
            } else if (map.get('A') < map.get('N')) {
                answer += "N";
            } else {
                answer += "A";
            }

        }else {
            answer += "A";
        }


        return answer;
    }
}