import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
         List<Integer> answer = new ArrayList<>();
        Map<String, Integer> num = new HashMap<>();
        Map<String, Map<Integer, Integer>> music = new HashMap<>();

        for (int i = 0; i < plays.length; i++) {
            if (!num.containsKey(genres[i])) {
                Map<Integer, Integer> map = new HashMap<>();
                map.put(i, plays[i]);
                music.put(genres[i], map);
                num.put(genres[i], plays[i]);
            } else {
                music.get(genres[i]).put(i, plays[i]);
                num.put(genres[i], num.get(genres[i]) + plays[i]);
            }
        }

        List<String> keySet = new ArrayList<>(num.keySet());
        Collections.sort(keySet, (s1, s2) -> num.get(s2) - num.get(s1));

        for (String key : keySet) {
            Map<Integer, Integer> map = music.get(key); // map<장르별 인덱스, plays 수>
            ArrayList<Integer> genreKey = new ArrayList<>(map.keySet()); // 장르별 인덱스 List

            Collections.sort(genreKey, (s1, s2) -> map.get(s2) - map.get(s1)); // 인덱스를 이용해 plays 수 정렬

            answer.add(genreKey.get(0));

            if (genreKey.size() > 1) {
                answer.add(genreKey.get(1));
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}