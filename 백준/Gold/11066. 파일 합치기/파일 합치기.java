import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(br.readLine());

        while (testCaseCount-- > 0) {
            calculateMinimumMergeCost(br);
        }
    }

    /**
     * 예시 흐름 (K = 4: 40, 30, 30, 50)
     * 길이 2 구간부터 시작
     * <p>
     * dp[1][2], dp[2][3], dp[3][4] 계산
     * <p>
     * 길이 3 구간
     * <p>
     * dp[1][3], dp[2][4]
     * <p>
     * 길이 4 구간
     * <p>
     * dp[1][4]
     * <p>
     * 각 구간을 가능한 모든 mid 지점으로 분할하면서, 최소 비용을 선택
     * <p>
     *
     * 구간의 길이(range)를 2부터 K까지 키우며 DP를 계산
     * <p>
     * 각 구간마다 가능한 모든 분할점(mid)을 확인
     * <p>
     * 분할 비용은 두 덩이의 최소 비용 + 합치는 비용 (누적합 사용)
     */
    private static void calculateMinimumMergeCost(BufferedReader br) throws IOException {
        int fileCount = Integer.parseInt(br.readLine());
        int[] fileSizes = new int[fileCount + 1];  // 입력값 저장
        int[] prefixSum = new int[fileCount + 1];  // 누적합 저장 배열

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= fileCount; i++) {
            fileSizes[i] = Integer.parseInt(st.nextToken());
            prefixSum[i] = prefixSum[i - 1] + fileSizes[i];
        }

        // dp[start][end] = start ~ end 구간을 하나로 합치는 최소 비용
        int[][] dp = new int[fileCount + 1][fileCount + 1];

        // 구간 길이를 2부터 fileCount까지 늘려가며 탐색
         for (int range = 2; range <= fileCount; range++) { // 예를 들어 fileCount가 4일 때 (A~B 탐색), (A~C 탐색), (A~D탐색)
            for (int start = 1; start <= fileCount - range + 1; start++) { // A~D를 탐색할 때 2번이면 충분함 (ABC+D, A+BCD) 또한, ABC의 최소는 이전에 구해놨고, BCD또한 구해놓은 상태
                int end = start + range - 1;
                dp[start][end] = Integer.MAX_VALUE;

                for (int mid = start; mid < end; mid++) {
                    int cost = dp[start][mid] + dp[mid + 1][end] + prefixSum[end] - prefixSum[start - 1];
                    dp[start][end] = Math.min(dp[start][end], cost);
                }
            }
        }

        System.out.println(dp[1][fileCount]);
    }

}
