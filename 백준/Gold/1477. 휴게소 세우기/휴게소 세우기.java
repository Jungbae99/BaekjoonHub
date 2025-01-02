import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 현재 휴게소
        int M = Integer.parseInt(st.nextToken()); // 지어야 하는 개수
        int L = Integer.parseInt(st.nextToken()); // 고속도로 길이

        int[] position = new int[N + 2]; // 처음 + 끝 + 휴게소들로 공간분할
        position[0] = 0; // 처음
        position[N + 1] = L; // 끝

        if (N > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                position[i] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(position);
        // 그니까 휴게소 간 최대 거리를 X 로 만들건데, 이 X가 최솟값이어야 함
        // 그러려면, 공간을 쪼갠다음 그 공간에 대해 X를 조절해가면서 휴게소를 넣는거
        // 휴게소가 아니라 X에 대해 이분탐색을 하는 것

        int left = 1;
        int right = L;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int count = 0;

            for (int i = 1; i < position.length; i++) {
                int distance = position[i] - position[i - 1]; // 휴게소거리
                count += (distance - 1) / mid;
            }

            // 개수를 셌는데 M개가 넘어간다? 너무 좁은거리
            // M개가 안된다? 최댓값이 아닌 것 줄일수있음
            if (count <= M) { // 같아도 길이를 줄여볼 수 있음.
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left);
    }
}
