class Solution {
    public int solution(int number, int limit, int power) {
        int[] numberArray = new int[number];

        int cnt = 0;

        for (int j = 1; j <= number; j++) {
            cnt = 0;
            for (int i = 1; i * i <= j; i++) {
                if (i * i == j) cnt++;
                else if (j % i == 0) cnt += 2;
            }
            numberArray[j-1] = cnt;
        }

        int answer = 0;
        for (int i = 0; i < numberArray.length; i++) {
            if (numberArray[i] > limit) answer += power;
            else answer += numberArray[i];
        }

        
        return answer;
    }
}