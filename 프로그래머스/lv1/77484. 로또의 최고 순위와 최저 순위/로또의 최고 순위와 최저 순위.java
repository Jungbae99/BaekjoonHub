import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        
        
         List<Integer> lottosList = new ArrayList<>();
        List<Integer> win_numsList = new ArrayList<>();

        int zero = 0;
        for (int i = 0; i < lottos.length; i++) {
            lottosList.add(lottos[i]);
            win_numsList.add(win_nums[i]);
            if (lottos[i]==0) zero ++;
        }
        int count = 0;
        for (int i = 0; i < lottos.length; i++) {
            for (int j = 0; j < win_nums.length; j++) {
                if (lottos[i] == win_nums[j]) {
                    lottosList.remove(Integer.valueOf(lottos[i]));
                    win_numsList.remove(Integer.valueOf(win_nums[j]));
                    count ++;
                }
            }
        }
        int min = count;
        int max = zero + count;

        if (min == 1 || min == 0){ min = 6;}
        else min = 7 - min;


        if (max == 1 || max == 0) max = 6;
        else max = 7 - max;
        
        int[] answer = {max, min};
        return answer;
    }
}