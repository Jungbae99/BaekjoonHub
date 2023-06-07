import java.util.Arrays;
import java.util.Scanner;


public class Main {

    static int num[] = new int[10];
    static int a[] = new int[10];
    static boolean c[] = new boolean[10];

    static StringBuilder go(int index, int n, int m){
        if (index == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                sb.append(num[a[i]]);
                if(i != m) sb.append(" ");
            }
            sb.append("\n");
            return sb;
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if(c[i]) continue;
            c[i] = true;
            a[index] = i;
            answer.append(go(index+1, n, m));
            c[i]=false;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }
        Arrays.sort(num, 0, n);
        System.out.println(go(0,n,m));
    }
}
