import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);
        
        int aPointer = 0;
        int bPointer = 0;

        for (int i = 0; i < A.length; i++) {
            if (B[bPointer] > A[aPointer]) {
                aPointer++;
                bPointer++;
                answer++;
            } else {
                bPointer++;
            }
        }


        return answer;
    }
}