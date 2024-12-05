import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
      public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]); // 10만
        int M = Integer.parseInt(split[1]); // 20억 (차이)
        // 투포인터 쓰면 될 듯
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int i = 0; // 왼쪽
        int j = 0; // 오른쪽
        int answer = Integer.MAX_VALUE;
        while (i < N) {
            if (arr[j] - arr[i] >= M) {
               answer = Math.min(answer, arr[j] - arr[i]);
                i++;
            } else {
                if (j == N-1) {
                    break;
                }
                j++;
            }
        }
        System.out.println(answer);
    }
    
}
    