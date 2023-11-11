class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int start = 0;
        int end = Integer.MAX_VALUE;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (check(mid, k, stones)) {

                start = mid + 1;
                answer = mid;

            } else {
                end = mid - 1;
            }
        }




        return answer ;
    }

    private boolean check(int mid, int k, int[] stones) {
        int count = 0;
        for (int i = 0; i < stones.length; i++) {
            if (stones[i] < mid) {
                count++;
                if (count >= k) return false;
            } else {
                count = 0;
            }
        }
        return true;
    }
}
