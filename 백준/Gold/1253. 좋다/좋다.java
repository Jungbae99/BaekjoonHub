
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 10
 * 1 2 3 4 5 6 7 8 9 10
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int left, right;
        int count = 0;
        for (int i = 0; i < N; i++) {
            left = 0;
            right = N - 1;
            while (left < right) {
                if (right != i && left != i) {
                    if (arr[left] + arr[right] < arr[i]) {
                        left++;
                    } else if (arr[left] + arr[right] > arr[i]) {
                        right--;
                    } else {
                        count++;
                        break;
                    }
                } else if (right == i) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        System.out.println(count);

        br.close();
    }
}
