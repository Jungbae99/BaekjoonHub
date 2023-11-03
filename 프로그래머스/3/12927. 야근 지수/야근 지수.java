import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
         long answer = 0;
        int N = n;

        Integer[] worksInt = new Integer[works.length];
        int i = 0;
        for (int work : works) {
            worksInt[i++] = work;
        }

        Arrays.sort(worksInt, Collections.reverseOrder());

        while (N != 0) {
            for (int j = 1; j < worksInt.length; j++) {
                if (worksInt[j - 1] < worksInt[j]) {
                    worksInt[j]--;
                    N--;
                    break;
                }
                if (j == worksInt.length - 1) {
                    worksInt[0]--;
                    N--;
                    break;
                }
            }
        }


        for (Integer integer : worksInt) {
            answer += (long)Math.pow(integer, 2);
        }

          if (worksInt[0] < 0) {
            answer = 0;
        }

        return answer;
    }
}