import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        int size = new HashSet<>(Arrays.asList(gems)).size();
        int length = gems.length;
        int max = Integer.MAX_VALUE;

        int start = 0, end = 0;
        int left = 0, right = 0;

        Map<String, Integer> map = new HashMap<>();

        while (true) {

            if (map.size() == size) {
                map.put(gems[left], map.get(gems[left]) - 1);

                if (map.get(gems[left]) == 0) {
                    map.remove(gems[left]);
                }
                left++;

            } else if (right == gems.length) {
                break;
            } else {
                map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
                right++;
            }

            if (map.size() == size) {
                if (right - left < max) {
                    max = right - left;
                    start = left + 1;
                    end = right;
                }
            }
        }

        return new int[]{start, end};
    }
}







