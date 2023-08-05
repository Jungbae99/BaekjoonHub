import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {        
        int answer =0;
        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            int l = citations.length - i; //개수와 비교
            if (citations[i] >= l) {
                answer = l;
                break;
            }
        }

        return answer;
    }
}