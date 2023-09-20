import java.util.*;
import java.util.stream.Collectors;


class Solution {
    public static String[] solution(String[] orders, int[] courses) {
        String[] answer = {};
        List<String> result = new ArrayList<>(); // 리스트를 하나 생성한다

        for (int course : courses) { // 만들고싶은 코스요리의 숫자 만큼 loop 를 돌 거다
            Map<String, Integer> map = new HashMap<>(); // 코스요리의 숫자 마다 map 을 생성해준다
            for (String order : orders) { // 주문을 한 사람들에 대해 2차원 loop 를 돌린다.
                int n = order.length(); // n 은 각각의 주문한 사람들이 주문한 음식의 개수이다.
                if (n < course) { // 만약 주문한 음식의 수가 코스요리 수보다 작으면 skip
                    continue;
                }
                char[] charArray = order.toCharArray(); // 한 사람에 대하여 주문을 문자 배열로 만든다.
                boolean[] visited = new boolean[n]; // 주문한 음식의 개수만큼 boolean 배열을 만들어준다.
                combination(map, charArray, visited, 0, n, course); // combination 호출
            }

            if (map.isEmpty()) {
                continue;
            }
            List<String> list = map.keySet().stream().sorted((c1, c2) -> Integer.compare(map.get(c2), map.get(c1))).collect(Collectors.toList());

            int max = map.get(list.get(0));
            if (max == 1) {
                continue;
            }
            result.add(list.remove(0));

            for (String s : list) {
                if (map.get(s) < max) {
                    break;
                }
                result.add(s);
            }
        }
        return result.stream().sorted().toArray(String[]::new);
    }

    // n 은 현재 order의 length // r 은 course 의 길이
    private static void combination(Map<String, Integer> map, char[] charArray, boolean[] visited, int start, int n, int r) {
        if (r == 0) { // course 의 길이가 0이라면..?
            refactorMap(map, charArray, visited, n);
            return;
        }
        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(map, charArray, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    private static void refactorMap(Map<String, Integer> map, char[] charArray, boolean[] visited, int n) {
        String s = getSortedString(combineString(charArray, visited, n));
        map.put(s, map.getOrDefault(s, 0) + 1);
    }

    private static String combineString(char[] charArray, boolean[] visited, int n) {

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                stringBuilder.append(charArray[i]);
            }
        }
        return stringBuilder.toString();
    }

    private static String getSortedString(String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
}

