import java.util.Scanner;

public class Main {
    static boolean broken[] = new boolean[10];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // 채널
        int num = in.nextInt(); // 고장난 리모콘개수

        for (int i = 0; i < num; i++) {
            int tmp = in.nextInt();
            broken[tmp] = true;
        }

        int answer = Math.abs(N - 100);

        for (int i = 0; i < 1000000; i++) {
            int cnt = check(i);
            if (cnt > 0) {
                int tmp = Math.abs(N - i);
                if (answer > cnt + Math.abs(N - i)) answer = cnt +Math.abs(N - i);
                // cnt는 버튼누른횟수, N - i 의 절댓값은 + 혹은 - 한 횟수

            }
        }

        System.out.println(answer);
    }

    private static int check(int c) {
        if(c==0){
            if(broken[0]==false) return 1;
            else return 0;
        }
        int cnt = 0;
        while(c>0){
            if(broken[c%10]) return 0;
            else{
                cnt ++;
                c /= 10;
            }
        }
        return cnt;
    }

}