import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        int tmp = 0;

        for (int i = 0; i < ingredient.length; i++) {
            stack.push(ingredient[i]);
            list.add(ingredient[i]);
            if (list.size() > 3) {
                if (list.get(list.size()-1) == 1 && list.get(list.size()-2) == 3 && list.get(list.size()-3) == 2 && list.get(list.size()-4) == 1) {
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    answer++;
                    list.remove(list.size() - 1);
                    list.remove(list.size() - 1);
                    list.remove(list.size() - 1);
                    list.remove(list.size() - 1);

                }
            }
        }
        
        
        return answer;
    }
}