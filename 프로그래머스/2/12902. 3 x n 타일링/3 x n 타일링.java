class Solution {
    public int solution(int n) {
          int answer = 0;
        long[] tile = new long[5001];
        int mod = 1000000007;
        // f[8] = f[6] * f[2] + f[4] * 2 + f[2] * 2

        tile[0] = 1;
        tile[2] = 3;

        for (int i = 4; i <= n; i += 2) {
            tile[i] = tile[i-2] * 3;
            for (int j = i - 4; j >= 0; j -= 2) {
                tile[i] += tile[j] * 2; 
            }
            tile[i] = tile[i] % mod;
        }
        return (int) (tile[n] % mod);
    }
}