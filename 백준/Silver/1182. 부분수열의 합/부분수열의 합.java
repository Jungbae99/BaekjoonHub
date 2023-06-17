import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int S = sc.nextInt();
        int a[] = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
        }

        int answer = 0;
        for (int i = 1; i < (1 << N); i++) {
            int sum = 0;
            for (int k = 0; k < N; k++) {
                if ((i & (1 << k)) != 0) {
                    sum += a[k];
                }
            }
            if (sum == S) {
                answer ++;
            }
        }

        System.out.println(answer);
    }
}