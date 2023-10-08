class Solution {
    public long solution(int w, int h) {
          long answer = (long)w * h;

        answer -= w + h - gcd(w, h);

        return answer;
    }

    private static long gcd(int w, int h) {
        if (w % h == 0) return h;
        return gcd(h, w % h);
    }
}