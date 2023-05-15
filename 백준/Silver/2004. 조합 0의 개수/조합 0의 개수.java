import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Try01 {
    public static int two(long num) {
        int cnt = 0;
        while (num >= 2) {
            cnt += num / 2;
            num /= 2;
        }
        return cnt;
    }

    public static int five(long num) {
        int cnt = 0;
        while (num >= 5) {
            cnt += num /5;
            num /= 5;
        }
        return cnt;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Try01 t = new Try01();
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        long cntTwo = t.two(n) - t.two(n-m) - t.two(m);
        long cntFive = t.five(n) - t.five(n-m) - t.five(m);

        System.out.println(Math.min(cntTwo, cntFive));
    }
}
