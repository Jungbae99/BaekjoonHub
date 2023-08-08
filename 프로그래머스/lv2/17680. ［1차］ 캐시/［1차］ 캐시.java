import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0){
            return cities.length * 5;
        }
        int answer = 0;
        List<String> cache = new LinkedList<>();

        for (int i = 0; i < cities.length; i++) {
            String s = cities[i].toUpperCase();
            if (cache.remove(s)) { // remove ? 삭제된게 있다면 ?
                answer += 1; // answer += 1;
                cache.add(s); // cache.add(s)
            } else {
                answer +=5 ;
                if (cache.size() >= cacheSize) {
                    cache.remove(0);
                }
                cache.add(s);
            }
        }

        return answer;
    }
}