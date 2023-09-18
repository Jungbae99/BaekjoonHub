import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int lt = 0;
        int rt = 0;
        int length = sequence.length;
        int sum = sequence[0];
        List<Integer> sub = new ArrayList<>();

        while(true){
            if(sum == k){
                sub.add(lt);
                sub.add(rt);
            }
            if(sub.size() == 4){
                if (sub.get(1) - sub.get(0) < sub.get(3) - sub.get(2)) {
                    sub.remove(2);
                    sub.remove(2);
                } else if(sub.get(1) - sub.get(0) > sub.get(3) - sub.get(2) ){
                    sub.remove(0);
                    sub.remove(0);
                } else {
                    sub.remove(2);
                    sub.remove(2);
                }
            }
            if (lt == length && rt == length) break;
            if(sum <= k && rt < length){
                rt++;
                if(rt < length) {
                    sum += sequence[rt];
                }
            } else {
                if (lt < length) sum -= sequence[lt++];
            }
        }
        
        return new int[]{sub.get(0), sub.get(1)};
    }
}