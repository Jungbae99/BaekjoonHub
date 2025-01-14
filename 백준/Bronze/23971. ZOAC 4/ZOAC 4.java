import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int H = arr[0]; // 열
        int W = arr[1]; // 행
        int N = arr[2]; // 세로 공백
        int M = arr[3]; // 가로 공백

        int count = 0;

        for (int i = 0; i < H; i += N + 1) {
            for (int j = 0; j < W; j += M + 1) {
                count++;
            }
        }

        System.out.println(count);
    }

}
