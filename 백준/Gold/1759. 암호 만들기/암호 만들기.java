import java.util.Arrays;
import java.util.Scanner;


class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt(); // 비밀번호길이
        int C = sc.nextInt(); // 배열의 길이
        String a[] = new String[C];

        for (int i = 0; i < C; i++) {
            a[i] = sc.next();
        }
        Arrays.sort(a);
        String ans = "";
        go(L, a, "", 0);


    }

    private static void go(int n, String[] a, String pass, int i) {
        if (n == pass.length()) {
            if (check(pass)) {
                System.out.println(pass);
            }
            return;
        }

            if(i>=a.length) return;
            go(n , a, pass + a[i], i + 1);
            go(n , a, pass, i + 1);
        }


    private static boolean check(String pass) {
        int ja = 0;
        int mo = 0;
        for (Character x : pass.toCharArray()) {
            if(x =='a' || x =='e' || x =='i' || x =='o' || x =='u') mo++;
            else ja++;
        }
        return (mo>=1 && ja>=2);
    }
}

