import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int answer = 0;
        // i는 자릿수 길이증가, start는 1,10,100...
        for (int i = 1, start = 1; start <= n; i++, start *= 10) {
            int end = (start * 10) - 1;
            if(end > n) end = n;
            answer += (end - start + 1) * i;
        }
        System.out.println(answer);
    }
}
