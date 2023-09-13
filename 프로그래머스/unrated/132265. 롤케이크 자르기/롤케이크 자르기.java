import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Set<Integer> smallBro = new HashSet<>();
        Map<Integer, Integer> bigBro = new HashMap<>();

        for (int i = 0; i < topping.length; i++) {
            bigBro.put(topping[i], bigBro.getOrDefault(topping[i], 0) + 1);
        }

        for (int i = 0; i < topping.length; i++) {
            smallBro.add(topping[i]);
            if (bigBro.get(topping[i]) - 1 == 0) {
                bigBro.remove(topping[i]);
            } else {
                bigBro.replace(topping[i], bigBro.get(topping[i]) - 1);
            }
            if (smallBro.size() == bigBro.size()) {
                answer++;
            }
        }
        
        
        return answer;
    }
}