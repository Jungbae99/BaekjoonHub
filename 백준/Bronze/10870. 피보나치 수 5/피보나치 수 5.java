import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(dfs(n));


    }

    private static int dfs(int n) {
        if(n == 0) return  n;
        else if (n == 1) return 1;
        return dfs(n-1) + dfs(n-2);
    }
}