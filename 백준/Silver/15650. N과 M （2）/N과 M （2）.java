import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        go(1,0, n, m);
    }


    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt();
    static int m = sc.nextInt();
    static int[]arr = new int[m];

    public static void go(int index,int selected, int n, int m){
        if(selected == m){
                for (int i = 0; i < m; i++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println();
                return;
        }
        if(index > n) return;
        arr[selected] = index;
        go(index+1, selected+1, n, m);

        go(index+1, selected, n, m);
    }
}
