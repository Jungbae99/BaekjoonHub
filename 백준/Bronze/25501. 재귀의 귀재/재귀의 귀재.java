import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

class Main {

    static int result;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = sc.nextInt();

        while (t-- > 0) {
            result = 0;
            bw.write(isPalindrome(sc.next()) + " " + result + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static int isPalindrome(String str) {
        return dfs(str, 0, str.length()-1);
    }
    private static int dfs(String str, int l, int r) {
        result++;
        if(l>=r) return 1;
        else if (str.charAt(l) != str.charAt(r)) return 0;
        else return dfs(str, l + 1, r - 1);
    }

}