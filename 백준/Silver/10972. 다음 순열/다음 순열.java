import java.util.Scanner;

public class Main {
    static int n;
    static int arr[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        if (nextpermulation()) {
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
        }else{
            System.out.println(-1);
        }
    }

    public static boolean nextpermulation() {
        int i = n-1;
        while (i > 0 && arr[i] < arr[i - 1]) i -= 1;
        if (i <= 0) return false;

        int j = n-1;
        while(arr[i-1] > arr[j]) j-= 1;

        swap(i-1, j);
        j = n - 1;
        while (j > i) {
            swap(j,i);
            j--; i++;
        }
        return true;
    }

    public static void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}