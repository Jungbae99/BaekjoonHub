
import java.util.Scanner;

class Main {
    static int n;
    static Long answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        answer = 1L;
        System.out.println(dfs(1, answer));
    }

    private static Long dfs(int dfsNum, Long answer) {
        if(dfsNum == n+1) return answer;
        else return dfs(dfsNum + 1, answer * dfsNum);
    }
}