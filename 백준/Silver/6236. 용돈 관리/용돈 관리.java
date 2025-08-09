import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // N일동안
        M = Integer.parseInt(st.nextToken()); // M번인출

        arr = new int[N];
        for (int i = 0; i< N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(search());
    }

    private static int search() {
        int start = 1;
        int end = 10000 * 100000;
        int mid;
        int result = 0;

        while (start <= end) {
            mid = start + (end - start) / 2;
            if (check(mid)) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return result;
    }

    private static boolean check(int mid) {
        int curSave = 0;
        int count = 0;

        for (int i = 0; i < N; i++) {
            int dayRequire = arr[i];
            if (dayRequire > mid) {
                return false;
            }

            if (curSave < dayRequire) {
                curSave = 0;
                curSave += mid;
                count++;
            }
            curSave -= dayRequire;
        }

        if (count > M) {
            return false;
        }
        return true;
    }
}
