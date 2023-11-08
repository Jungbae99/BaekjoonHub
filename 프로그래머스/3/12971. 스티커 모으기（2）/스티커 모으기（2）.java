class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        int length = sticker.length;

        if (length == 1) return sticker[0];

        int[] dp1 = new int[length];
        int[] dp2 = new int[length];

        // 첫 번째 스티커를 뗀다면?
        dp1[0] = sticker[0];
        dp1[1] = sticker[0];

        for (int i = 2; i < sticker.length - 1; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + sticker[i]);
        }


        // 안 뗀다면?
        dp2[0] = 0;
        dp2[1] = sticker[1];

        for (int i = 2; i < length; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + sticker[i]);
        }

        answer = Math.max(dp1[length - 2], dp2[length - 1]);
        return answer;
    }
}