
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n;
    static int a[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        int count = 0;
        for (int i = 0; i < n-1; i++) {
            count += Math.abs(a[i] - a[i+1]);
        }
        int ans = count;

        do {
            int temp = calculate(a);
            ans = Math.max(ans, temp);
        } while(next(n, a));

        System.out.println(ans);

    }

    public static int calculate(int a[]) {
        int sum = 0;
        for (int i=1; i<a.length; i++) {
            sum += Math.abs(a[i] - a[i-1]);
        }
        return sum;
    }
    public static boolean next(int n, int arr[]) {
        int i = n-1;
        while(i >= 1 && arr[i] <= arr[i-1]) i--;
        if(i<=0) return false;

        int j = n-1;
        while(arr[i-1] >= arr[j]) j--;
        swap(i-1, j);

        j = n-1;
        while (i < j) {
            swap(i, j);
            i++; j--;
        }
        return true;
    }

    private static void swap(int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }


}



