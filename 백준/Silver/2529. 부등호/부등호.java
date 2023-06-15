
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Main {
    static int n;
    static char a[] = new char[20];
    static ArrayList<String> answer = new ArrayList<>();
    static boolean[] check = new boolean[10];

    static boolean ok(String num) {
        for (int i = 0; i < n; i++) {
            if (a[i] == '<') {
                if(num.charAt(i) > num.charAt(i+1)) return false;
            } else if (a[i] == '>') {
                if(num.charAt(i) < num.charAt(i+1)) return false;
            }
        }
        return true;
    }

    private static void go(int index, String num) {
        if (index == n + 1) {
            if (ok(num)) {
                answer.add(num);
            }
            return;
        }
        for (int i = 0; i <= 9; i++) {
            if(check[i]) continue;
            check[i] = true;
            go(index + 1, num + Integer.toString(i));
            check[i] = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = sc.next().toCharArray()[0];
        }
        go(0, "");
        Collections.sort(answer);
        int m = answer.size();
        System.out.println(answer.get(m - 1));
        System.out.println(answer.get(0));

    }
}