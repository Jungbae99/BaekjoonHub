import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();

        System.out.println(tiling(i));
    }
 private static long tiling(int n) {
        long[] arr = new long[n + 1];
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 3;
     
        arr[2] = 2;
        arr[3] = 3;

        for (int i = 4; i <= n; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 10007;
        }

        return arr[n];
    }
}
